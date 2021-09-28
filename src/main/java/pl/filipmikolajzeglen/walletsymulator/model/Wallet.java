package pl.filipmikolajzeglen.walletsymulator.model;

import pl.filipmikolajzeglen.walletsymulator.enums.MonthsEnum;
import pl.filipmikolajzeglen.walletsymulator.service.Simulator;

import java.util.*;

public class Wallet extends Simulator {
    private Integer salary;
    private Integer credit;
    private Integer currentMoney;
    private Integer financialCushion;
    private Integer periodInYears = 1;
    private MonthsEnum startMonth = MonthsEnum.JANUARY;
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

    public Wallet(Integer salary,
                  Integer credit,
                  Integer currentMoney,
                  Integer financialCushion,
                  Integer periodInYears,
                  MonthsEnum startMonth,
                  List<Expense> expenses) {
        this.salary = salary;
        this.credit = credit;
        this.currentMoney = currentMoney;
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

    public Integer getCurrentMoney() {
        setCurrentMoney(0);
        return currentMoney; }

    public void setCurrentMoney(Integer currentMoney) { this.currentMoney = currentMoney; }

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
        return "pl.filipmikolajzeglen.walletsymulator.model.Wallet{" +
                "salary=" + salary +
                ", credit=" + credit +
                ", currentMoney=" + currentMoney +
                ", financialCushion=" + financialCushion +
                ", periodInYears=" + periodInYears +
                ", startMonth=" + startMonth +
                ", expenses=" + expenses +
                '}';
    }

    public static class Builder {
        private Integer salary;
        private Integer credit;
        private Integer currentMoney;
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

        public Builder setCurrentMoney(Integer currentMoney) {
            this.currentMoney = currentMoney;
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
            return new Wallet(
                    salary,
                    credit,
                    currentMoney,
                    financialCushion,
                    periodInYears,
                    startMonth,
                    expenses
            );
        }
    }
}
