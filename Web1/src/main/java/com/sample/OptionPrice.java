package com.sample;

public class OptionPrice {

    private double callBid;
    private double putBid;
    private double callAsk;
    private double putAsk;
    private double strike;
    private double expiration;

    public OptionPrice(double callBid, double callAsk, double putBid, double putAsk, double strike)
    {
        this.callBid = callBid;
        this.putBid = putBid;
        this.callAsk = callAsk;
        this.putAsk = putAsk;
        this.strike = strike;
    }

    public double getCallBid() { return callBid; }
    public double getCallAsk() { return callAsk; }
    public double getPutBid() { return putBid; }
    public double getPutAsk() { return putAsk; }

    public double getStrike() { return strike; }
    public double getExpiration() { return expiration; }
}
