package com.javamodule.YahooAPI;

import com.javamodule.object.DateObject;
import com.javamodule.object.OptionPrice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class YahooAddress {


    private String prefix = "https://query1.finance.yahoo.com/v7/finance/download/";
    private String suffixMaxPart1 = "?period1=";
    private String suffixMaxPart2 = "&period2=";
    private String suffixMaxPartdefault = "&interval=1mo&events=history";
    private String suffixMaxPartdefaulDaily = "&interval=1d&events=history";
    private String finalAddress;
    private boolean parsingSuccess = true;

    public YahooAddress(String instrument) {
        try{
            final Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, -1);
            DateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy");
            DateObject Yesterday = new DateObject(dateFormat.format(cal.getTime()));
            OptionPrice.InstrumentName instName = new OptionPrice.InstrumentName(instrument);
            finalAddress = prefix + instName.getInstName() + suffixMaxPart1 + "0"
                    + suffixMaxPart2 + Yesterday.getEpochFormat() + suffixMaxPartdefault;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public YahooAddress(String instrument, String startDate, String endDate) {
        try {
            OptionPrice.InstrumentName instName = new OptionPrice.InstrumentName(instrument);
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            DateObject stDate = new DateObject(startDate, dt);
            DateObject edDate = new DateObject(endDate, dt);
            if (!stDate.getparsingSuccess() || !edDate.getparsingSuccess())
                parsingSuccess = false;
            finalAddress = prefix + instName.getInstName() + suffixMaxPart1 + stDate.getEpochFormat()
                    + suffixMaxPart2 + edDate.getEpochFormat() + suffixMaxPartdefaulDaily;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
    }

    public String getFinalAddress() {
        return finalAddress;
    }

    public boolean getParsingSuccess(){
        return parsingSuccess;
    }
}
