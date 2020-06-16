package com.sample.model;

public class InstrumentName {

    private String spx = "%5EGSPC";
    private String ndx = "%5EIXIC";
    private String dji = "%5EDJI";
    private String instName = "";

    public InstrumentName(String instrument)
    {
        if (instrument.equals("SPX"))
            this.instName = spx;
        else if (instrument.equals("NDX"))
            this.instName = ndx;
        else if (instrument.equals("DJI"))
            this.instName = dji;
        else
            this.instName = instrument;
    }

    public String getInstName() { return instName; }
}