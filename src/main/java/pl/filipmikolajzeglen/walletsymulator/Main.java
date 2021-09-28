package pl.filipmikolajzeglen.walletsymulator;

import pl.filipmikolajzeglen.walletsymulator.model.Expense;
import pl.filipmikolajzeglen.walletsymulator.model.Wallet;

import static pl.filipmikolajzeglen.walletsymulator.enums.MonthsEnum.*;
import static pl.filipmikolajzeglen.walletsymulator.service.Simulator.startSimulation;

public class Main {
    public static void main(String[] args) {

        Wallet walletTo2021 = new Wallet.Builder()
                .setStartMonth(OCTOBER)
                .setSalary(3613)
                .setCredit(2797)
                .setFinancialCushion(1321)
                .setPeriodInYears(1)

                .addExpense(new Expense("Food", 700))
                .addExpense(new Expense("Mobile", 30))
                .addExpense(new Expense("Transport", 100))
                .addExpense(new Expense("University", 2100, OCTOBER))
                .addExpense(new Expense("Credit", 1000))
                .build();

        startSimulation(walletTo2021);

        Wallet walletTo2022 = new Wallet.Builder()
                .setStartMonth(JANUARY)
                .setSalary(3613)
                .setCredit(walletTo2021.getCredit())
                .setFinancialCushion(walletTo2021.getFinancialCushion())
                .setPeriodInYears(2)

                .addExpense(new Expense("Food", 700))
                .addExpense(new Expense("Mobile", 30))
                .addExpense(new Expense("Transport", 100))
                .addExpense(new Expense("University", 2100, FEBRUARY))
                .build();

        startSimulation(walletTo2022);
    }
}
