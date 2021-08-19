public class Symulator {

    private int getDifference(int amount, int payment) {
        return amount - payment;
    }

    private String checkLengthOfExpenseName(Expense expanse) {
        if (expanse.getExpenseName().length() < 4) return " \t\t\t [";
        if (expanse.getExpenseName().length() < 7) return " \t\t [";
        else return " \t [";
    }

    // Print info about checking month
    // If provided cash is lower than expanse then get cash from financial cushion
    private void printExpense(Expense expanse, int currentCash, int financialCushion) {
        if (currentCash < expanse.getExpenseValue()) {
            int difference = Math.abs(currentCash - expanse.getExpenseValue());
            financialCushion -= difference;
            currentCash += difference;
            System.out.println("\t - "
                    + expanse.getExpenseName()
                    + checkLengthOfExpenseName(expanse)
                    + currentCash + " - " + expanse.getExpenseValue() + " \t= "
                    + getDifference(currentCash, expanse.getExpenseValue())
                    + " \tPLN] ADDED " + difference + " FROM FINANCIAL CUSHION");
        } else {
            System.out.println("\t - "
                    + expanse.getExpenseName()
                    + checkLengthOfExpenseName(expanse)
                    + currentCash + " - " + expanse.getExpenseValue() + " \t= "
                    + getDifference(currentCash, expanse.getExpenseValue())
                    + " \tPLN]");
        }
    }

    // Create simulation depended on entered wallet information
    // 1. Provide information about range of simulation time in year
    // 2. Provide start Month. Default id January
    // 3. Init summary and add credit information if exist
    public void startSimulation(Wallet wallet) {
        for (int y = 0; y < wallet.getPeriodInYears(); y++) {
            int startMonth = wallet.getStartMonth() != null ? wallet.getStartMonth().getMonth() : 1;
            for (int month = startMonth; month < 13; month++) {
                System.out.println("--------- " + MonthsEnum.choseMonth(month).toUpperCase() + " ------------------------------------\n");
                System.out.println("YOUR SALARY: " + wallet.getSalary()
                        + " PLN (FC " + wallet.getFinancialCushion() + " PLN) "
                        + (wallet.getCredit() != null && wallet.getCredit() > 0
                        ? " CREDIT: " + wallet.getCredit() + "\n"
                        : "\n"));

                int currentCash = wallet.getSalary();
                int financialCushion = wallet.getFinancialCushion();
                for (Expense expanse : wallet.getExpenses()) {
                    if (expanse.getExpenseName().toUpperCase().contains("CREDIT") && wallet.getCredit() > 0) {
                        if (wallet.getCredit() < expanse.getExpenseValue()) {
                            expanse.setExpenseValue(wallet.getCredit());
                        }
                        printExpense(expanse, wallet.getCredit(), financialCushion);
                        wallet.setCredit(wallet.getCredit() - expanse.getExpenseValue());
                    } else if (expanse.getStart() == null && expanse.getEnd() == null || expanse.getStart().getMonth() == month) {
                        printExpense(expanse, currentCash, financialCushion);
                        currentCash = getDifference(currentCash, expanse.getExpenseValue());
                    }
                }

                wallet.setFinancialCushion(financialCushion += currentCash);
                System.out.println("\n\t -> THE REST OF MONEY: " + currentCash + " PLN");
                System.out.println("\t -> NEW FC CUSHION: " + financialCushion + " PLN");
                System.out.println(wallet.getCredit() != null && wallet.getCredit() > 0
                        ? "\t -> NEW CREDIT: " + wallet.getCredit() + " PLN\n"
                        : "");
            }
        }
    }
}
