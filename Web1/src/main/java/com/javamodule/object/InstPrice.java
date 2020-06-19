package com.javamodule.object;

public class InstPrice {

    private double open;
    private double high;
    private double low;
    private double close;
    private double adjClose;
    private long volume;
    private String instDate;

    public InstPrice(String instDate, double open, double close,
                     double low, double high, double adjClose, long volume)
    {
        this.instDate = instDate;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.adjClose = adjClose;
        this.volume = volume;
    }

    public String getInstDate() { return instDate; }
    public double getOpen() { return open; }
    public double getClose() { return close; }
    public double getHigh() { return high; }
    public double getLow() { return low; }
    public double getAdjClose() { return adjClose; }
    public long getVolume() { return volume; }
}