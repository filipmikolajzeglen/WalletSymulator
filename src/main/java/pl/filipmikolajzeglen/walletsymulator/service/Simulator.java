package pl.filipmikolajzeglen.walletsymulator.service;

import pl.filipmikolajzeglen.walletsymulator.enums.MonthsEnum;
import pl.filipmikolajzeglen.walletsymulator.model.Expense;
import pl.filipmikolajzeglen.walletsymulator.model.Wallet;

import java.time.LocalDate;

public class Simulator {

    private static final LocalDate currentDate = LocalDate.now();
    private static Integer year = null;

    public static int getYear(int month) {
        if (year == null) year = currentDate.getYear();
        if (month == 1) year += 1;
        return year;
    }

    private static int getDifference(int amount, int payment) {
        return amount - payment;
    }

    private static String checkLengthOfExpenseName(Expense expanse) {
        if (expanse.getExpenseName().length() < 4) return " \t\t\t";
        if (expanse.getExpenseName().length() < 8) return " \t\t";
        else return " \t";
    }

    private static String checkLength(String targetLength) {
        if (targetLength.length() < 10) return " \t\t";
        else return " \t";
    }

    // Print info about checking month
    // If provided cash is lower than expanse then get cash from financial cushion
    private static void printExpense(Expense expanse, int currentCash, int financialCushion) {
        String subtraction;
        if (currentCash < expanse.getExpenseValue()) {
            int difference = Math.abs(currentCash - expanse.getExpenseValue());
            financialCushion -= difference;
            currentCash += difference;
            subtraction = currentCash + " - " + expanse.getExpenseValue();
            System.out.println("\t - "
                    + expanse.getExpenseName()
                    + checkLengthOfExpenseName(expanse)
                    + "[" + subtraction + checkLength(subtraction) + " = "
                    + getDifference(currentCash, expanse.getExpenseValue())
                    + " PLN] - " + difference + " FC");
        } else {
            subtraction = currentCash + " - " + expanse.getExpenseValue();
            System.out.println("\t - "
                    + expanse.getExpenseName()
                    + checkLengthOfExpenseName(expanse)
                    + "[" + subtraction + checkLength(subtraction) + " = "
                    + getDifference(currentCash, expanse.getExpenseValue())
                    + " PLN]");
        }
    }

    private static String printDate(int month) {
        return MonthsEnum.choseMonth(month).toUpperCase() + " " + getYear(month);
    }

    private static String printLine(String date) {
        StringBuilder line = new StringBuilder(" ");
        int extraLine = date.length() < 15 ? 15 - date.length() : 0;
        line.append("─".repeat(27 + extraLine));
        return line + "\n";
    }

    private static void printHeader(Wallet wallet, int month) {
        String header = printDate(month);
        System.out.println("────────── " + header + printLine(header));
        System.out.println("YOUR SALARY: "
                + wallet.getSalary()
                + " PLN (FC " + wallet.getFinancialCushion() + " PLN) "
                + (wallet.getCredit() != null && wallet.getCredit() > 0
                ? " CREDIT: " + wallet.getCredit() + "\n"
                : "\n"));
    }

    private static void printSummary(Wallet wallet, int currentCash, int financialCushion) {
        wallet.setFinancialCushion(financialCushion += currentCash);
        System.out.println("\n\t -> THE REST OF MONEY: " + currentCash + " PLN");
        System.out.println("\t -> NEW FC CUSHION: " + financialCushion + " PLN");
        System.out.println(wallet.getCredit() != null && wallet.getCredit() > 0
                ? "\t -> NEW CREDIT: " + wallet.getCredit() + " PLN\n"
                : "");
    }

    private static void printExpensesPerMonth(Wallet wallet, int month) {
        printHeader(wallet, month);

        int currentCash = wallet.getSalary();
        int financialCushion = wallet.getFinancialCushion();

        for (Expense expense : wallet.getExpenses()) {
            if (expense.getExpenseName().toUpperCase().contains("CREDIT") && wallet.getCredit() > 0) {
                if (wallet.getCredit() < expense.getExpenseValue()) {
                    expense.setExpenseValue(wallet.getCredit());
                }
                printExpense(expense, currentCash, financialCushion);
                currentCash = getDifference(currentCash, expense.getExpenseValue());
                wallet.setCredit(wallet.getCredit() - expense.getExpenseValue());
            } else if (expense.getStart() == null && expense.getEnd() == null || expense.getStart().getMonth() == month) {
                printExpense(expense, currentCash, financialCushion);
                currentCash = getDifference(currentCash, expense.getExpenseValue());
            }
        }

        printSummary(wallet, currentCash, financialCushion);
    }

//    public void startSimulation(Wallet wallet) {
//        for (int y = 0; y < wallet.getPeriodInYears(); y++) {
//            int startMonth = wallet.getStartMonth() != null ? wallet.getStartMonth().getMonth() : 1;
//            for (int month = startMonth; month < 13; month++) {
//                printExpensesPerMonth(wallet, month);
//            }
//        }
//    }

    public static void startSimulation(Wallet wallet) {
        for (int y = 0; y < wallet.getPeriodInYears(); y++) {
            int startMonth = wallet.getStartMonth() != null ? wallet.getStartMonth().getMonth() : 1;
            for (int month = startMonth; month < 13; month++) {
                printExpensesPerMonth(wallet, month);
            }
        }
    }
}
