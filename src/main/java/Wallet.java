import java.util.*;

public class Wallet extends Symulator {
    private Integer salary;
    private Integer credit;
    private Integer financialCushion;
    private Integer periodInYears = 1;
    private MonthsEnum startMonth;
    private List<Expense> expenses;

    public Wallet() {
    }

    public Wallet(Integer salary,
                  Integer credit,
                  Integer financialCushion,
                  Integer periodInYears,
                  MonthsEnum startMonth,
                  List<Expense> expenses) {
        this.salary = salary;
        this.credit = credit;
        this.financialCushion = financialCushion;
        this.periodInYears = periodInYears;
        this.startMonth = startMonth;
        this.expenses = expenses;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getCredit() { return credit; }

    public void setCredit(Integer credit) { this.credit = credit; }

    public Integer getFinancialCushion() { return financialCushion; }

    public void setFinancialCushion(Integer financialCushion) {
        this.financialCushion = financialCushion;
    }

    public Integer getPeriodInYears() { return periodInYears; }

    public void setPeriodInYears(Integer periodInYears) { this.periodInYears = periodInYears; }

    public MonthsEnum getStartMonth() { return startMonth; }

    public void setStartMonth(MonthsEnum startMonth) { this.startMonth = startMonth; }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "salary=" + salary +
                ", credit=" + credit +
                ", financialCushion=" + financialCushion +
                ", periodInYears=" + periodInYears +
                ", startMonth=" + startMonth +
                ", expenses=" + expenses +
                '}';
    }

    public static class Builder {
        private Integer salary;
        private Integer credit;
        private Integer financialCushion;
        private Integer periodInYears;
        private MonthsEnum startMonth;
        private List<Expense> expenses;

        public Builder() {
            this.expenses = new LinkedList<>();
        }

        public Builder setSalary(Integer salary) {
            this.salary = salary;
            return this;
        }

        public Builder setCredit(Integer credit) {
            this.credit = credit;
            return this;
        }

        public Builder setStartMonth(MonthsEnum startMonth) {
            this.startMonth = startMonth;
            return this;
        }

        public Builder setFinancialCushion(Integer financialCushion) {
            this.financialCushion = financialCushion;
            return this;
        }

        public Builder setPeriodInYears(Integer periodInYears) {
            this.periodInYears = periodInYears;
            return this;
        }

        public Builder addExpense(Expense expense) {
            this.expenses.add(expense);
            return this;
        }

        public Wallet build() {
            return new Wallet(salary, credit, financialCushion, periodInYears, startMonth, expenses);
        }
    }
}
