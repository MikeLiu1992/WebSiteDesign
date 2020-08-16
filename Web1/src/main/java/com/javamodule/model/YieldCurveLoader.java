package com.javamodule.model;
import com.javamodule.object.YieldCurve;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import com.javamodule.object.DateObject;
import com.javamodule.object.OptionPrice;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YieldCurveLoader {

    private ArrayList<YieldCurve> yieldCurveList = new ArrayList<YieldCurve>();
    private String Treasury = "https://www.treasury.gov/resource-center/data-chart-center/interest-rates/pages/textview.aspx?data=yield";
    private String CSSLocator = "#t-content-main-content > div > table > tbody > tr > td > div > table";

    public YieldCurveLoader(){
        try {
            Document doc = Jsoup.connect(Treasury).get();

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


}
