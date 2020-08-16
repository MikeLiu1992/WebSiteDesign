package com.javamodule.object;

public class YieldCurve {
    private double rate;
    private double date;

    public YieldCurve(double amount, double date)
    {
        this.rate = amount;
        this.date = date;
    }

    public double getRate() {
        return rate;
    }

    public double getDate() {
        return date;
    }
}
