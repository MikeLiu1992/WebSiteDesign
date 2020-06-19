package com.javamodule.object;

public class Dividend {
    private double amount;
    private double date;

    public Dividend(double amount, double date)
    {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public double getDate() {
        return date;
    }
}
