package com.sample;

public class YahooAddress {
    private String spx = "%5EGSPC";
    private String ndx = "%5EIXIC";
    private String dji = "%5EDJI";


    private String prefix = "https://query1.finance.yahoo.com/v7/finance/download/";
    private String suffix = "?period1=1560474257&period2=1592096657&interval=1d&events=history";
    private String finalAddress;

    public YahooAddress(String instrument)
    {
        if (instrument.equals("SPX"))
        {
            finalAddress = prefix + this.spx + suffix;
        }
        else if (instrument.equals("NDX"))
        {
            finalAddress = prefix + this.ndx + suffix;
        }
        else if (instrument.equals("DJI"))
        {
            finalAddress = prefix + this.dji + suffix;
        }
        else
        {
            finalAddress = prefix + instrument + suffix;
        }
    }

    public String getFinalAddress() {
        return finalAddress;
    }

}
