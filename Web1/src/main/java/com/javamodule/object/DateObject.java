package com.javamodule.object;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateObject {

    private String dateFormat;
    private long epochFormat;

    public long convertToEpoch(String dateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        Date dt = sdf.parse(dateFormat);
        long epoch = dt.getTime();
        return (long)(epoch/1000);
    }

    public long convertToEpoch(String dateFormat, SimpleDateFormat df) throws ParseException {
        Date dt = df.parse(dateFormat);
        long epoch = dt.getTime();
        return (long)(epoch/1000);
    }

    public DateObject(String dateFormat) throws ParseException {
        this.dateFormat = dateFormat;
        this.epochFormat = convertToEpoch(dateFormat);
    }

    public DateObject(String dateFormat, String epochFormat) {
        this.dateFormat = dateFormat;
        this.epochFormat = Long.parseLong(epochFormat);
    }

    public DateObject(String dateFormat, SimpleDateFormat simpleDateFormat) throws ParseException {
        this.dateFormat = dateFormat;
        this.epochFormat = convertToEpoch(dateFormat, simpleDateFormat);
    }

    public String getDateFormat() { return dateFormat; }
    public long getEpochFormat() { return epochFormat; }

}