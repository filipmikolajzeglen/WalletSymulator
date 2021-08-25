public class Main {
    public static void main(String[] args) {

        Wallet walletAUGtoNOV = new Wallet.Builder()
                .setStartMonth(MonthsEnum.SEPTEMBER)
                .setSalary(3613)
                .setCredit(3065)
                .setFinancialCushion(1000)
                .setPeriodInYears(1)

                .addExpense(new Expense("Food", 800))
                .addExpense(new Expense("Mobile", 30))
                .addExpense(new Expense("Transport", 200))
                .addExpense(new Expense("Gym", 1000, MonthsEnum.SEPTEMBER))
                .addExpense(new Expense("Gym", 600, MonthsEnum.OCTOBER))
                .addExpense(new Expense("Gym", 600, MonthsEnum.NOVEMBER))
                .addExpense(new Expense("University", 2100, MonthsEnum.OCTOBER))
                .addExpense(new Expense("Deposit", 1800, MonthsEnum.DECEMBER))
                .addExpense(new Expense("Apartment", 1800, MonthsEnum.DECEMBER))
                .addExpense(new Expense("Credit", 1000))
                .build();

        walletAUGtoNOV.startSimulation(walletAUGtoNOV);

        Wallet walletJANtoNOV = new Wallet.Builder()
                .setStartMonth(MonthsEnum.JANUARY)
                .setSalary(3613)
                .setFinancialCushion(walletAUGtoNOV.getFinancialCushion())
                .setPeriodInYears(1)

                .addExpense(new Expense("Apartment", 1800))
                .addExpense(new Expense("Food", 800))
                .addExpense(new Expense("Mobile", 30))
                .addExpense(new Expense("Transport", 200))
                .addExpense(new Expense("Gym", 50))
                .addExpense(new Expense("University", 2100, MonthsEnum.FEBRUARY))
                .build();

        walletAUGtoNOV.startSimulation(walletJANtoNOV);
    }
}
