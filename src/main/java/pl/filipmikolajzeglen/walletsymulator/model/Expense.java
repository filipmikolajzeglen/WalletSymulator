package pl.filipmikolajzeglen.walletsymulator.model;

import pl.filipmikolajzeglen.walletsymulator.enums.MonthsEnum;

public class Expense {
    private String expenseName;
    private Integer expenseValue;
    private MonthsEnum start;
    private MonthsEnum end;

    public Expense() {
    }

    public Expense(String expenseName, Integer expenseValue) {
        this.expenseName = expenseName;
        this.expenseValue = expenseValue;
    }

    public Expense(String expenseName, Integer expenseValue, MonthsEnum start) {
        this.expenseName = expenseName;
        this.expenseValue = expenseValue;
        this.start = start;
    }

    public Expense(String expenseName, Integer expenseValue, MonthsEnum start, MonthsEnum end) {
        this.expenseName = expenseName;
        this.expenseValue = expenseValue;
        this.start = start;
        this.end = end;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public Integer getExpenseValue() {
        return expenseValue;
    }

    public void setExpenseValue(Integer expenseValue) {
        this.expenseValue = expenseValue;
    }

    public MonthsEnum getStart() {
        return start;
    }

    public void setStart(MonthsEnum start) {
        this.start = start;
    }

    public MonthsEnum getEnd() {
        return end;
    }

    public void setEnd(MonthsEnum end) {
        this.end = end;
    }

}
