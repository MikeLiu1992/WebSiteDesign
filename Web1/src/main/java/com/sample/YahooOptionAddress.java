package com.sample;

import com.sample.model.InstrumentName;

public class YahooOptionAddress {

    private String prefix = "https://finance.yahoo.com/quote/";
    private String suffix = "/options";
    private String callSelector = "#Col1-1-OptionContracts-Proxy > section > section:nth-child(2) > div:nth-child(2) > div";
    private String putSelector = "#Col1-1-OptionContracts-Proxy > section > section:nth-child(3) > div:nth-child(2) > div";
    private String finalAddress;

    public YahooOptionAddress(String instrument)
    {
        InstrumentName instName = new InstrumentName(instrument);
        finalAddress = prefix + instName.getInstName() + suffix;
    }

    public String getFinalAddress() {
        return finalAddress;
    }
    public String getCallSelector() { return callSelector; }
    public String getPutSelector() { return putSelector; }
}
