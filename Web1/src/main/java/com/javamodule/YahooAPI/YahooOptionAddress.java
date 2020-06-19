package com.javamodule.YahooAPI;

import com.javamodule.object.OptionPrice;

public class YahooOptionAddress {

    private String prefix = "https://finance.yahoo.com/quote/";
    private String suffix = "/options";
    private String dateSuffix = "/options?date=";
    private String callSelector = "#Col1-1-OptionContracts-Proxy > section > section:nth-child(2) > div:nth-child(2) > div";
    private String putSelector = "#Col1-1-OptionContracts-Proxy > section > section:nth-child(3) > div:nth-child(2) > div";
    private String finalAddress;
    private String expSelector = "#Col1-1-OptionContracts-Proxy > section > div > div:first-child";

    public YahooOptionAddress(String instrument)
    {
        OptionPrice.InstrumentName instName = new OptionPrice.InstrumentName(instrument);
        finalAddress = prefix + instName.getInstName() + suffix;
    }

    public YahooOptionAddress(String instrument, String epochDate)
    {
        OptionPrice.InstrumentName instName = new OptionPrice.InstrumentName(instrument);
        finalAddress = prefix + instName.getInstName() + dateSuffix + epochDate;
    }

    public String getFinalAddress() {
        return finalAddress;
    }
    public String getCallSelector() { return callSelector; }
    public String getPutSelector() { return putSelector; }
    public String getExpSelector() { return expSelector; }
}
