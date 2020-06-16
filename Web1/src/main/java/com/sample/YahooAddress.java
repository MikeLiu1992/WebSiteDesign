package com.sample;

import com.sample.model.InstrumentName;

public class YahooAddress {


    private String prefix = "https://query1.finance.yahoo.com/v7/finance/download/";
    private String suffix = "?period1=1560474257&period2=1592096657&interval=1d&events=history";
    private String finalAddress;

    public YahooAddress(String instrument)
    {
        InstrumentName instName = new InstrumentName(instrument);
        finalAddress = prefix + instName.getInstName() + suffix;
    }

    public String getFinalAddress() {
        return finalAddress;
    }
}
