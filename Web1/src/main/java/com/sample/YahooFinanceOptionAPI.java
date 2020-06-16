package com.sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YahooFinanceOptionAPI {
    private ArrayList<OptionPrice> optPrice = new ArrayList<OptionPrice>();
    private boolean fileFound = true;

    public double stringConversion(String str) throws ParseException {
        str = str.replaceAll(",","");
        if (str == "")
            return 0;
        return Double.parseDouble(str);
    }

    public YahooFinanceOptionAPI(String args) throws IOException {
        YahooOptionAddress url = new YahooOptionAddress(args);
        try {
            Document doc = Jsoup.connect(url.getFinalAddress()).get();
            Element callTables = doc.select(url.getCallSelector()).first();
            Element putTables= doc.select(url.getPutSelector()).first();
            Elements callRows = callTables.select("tr");
            Elements putRows = putTables.select("tr");
            double [][] callPrice = new double[callRows.size()][3];
            double [][] putPrice = new double[putRows.size()][3];

            for (int i = 0; i < callRows.size(); i++) {
                Element row = callRows.get(i);
                Elements cols = row.select("td");
                if ( cols.size() > 0 && !cols.get(0).text().equals("-") && !cols.get(6).text().equals("-"))
                {
                    double bidPrice = stringConversion(cols.get(4).text());
                    double askPrice = stringConversion(cols.get(5).text());
                    double strike = stringConversion(cols.get(2).text());
                    callPrice[i][0] = bidPrice;
                    callPrice[i][1] = askPrice;
                    callPrice[i][2] = strike;
                }
            }
            for (int i = 0; i < putRows.size(); i++) {
                Element row = putRows.get(i);
                Elements cols = row.select("td");
                if ( cols.size() > 0 && !cols.get(0).text().equals("-") && !cols.get(6).text().equals("-"))
                {
                    double bidPrice = stringConversion(cols.get(4).text());
                    double askPrice = stringConversion(cols.get(5).text());
                    double strike = stringConversion(cols.get(2).text());
                    putPrice[i][0] = bidPrice;
                    putPrice[i][1] = askPrice;
                    putPrice[i][2] = strike;
                }
            }
            Arrays.sort(callPrice, Comparator.comparingDouble(o -> o[2]));
            Arrays.sort(putPrice, Comparator.comparingDouble(o -> o[2]));
            int callCounter = 0, putCounter = 0;
            while (callCounter < callRows.size() && putCounter < putRows.size())
            {
                while (callPrice[callCounter][2] < putPrice[putCounter][2])
                    callCounter ++;
                while (callPrice[callCounter][2] > putPrice[putCounter][2])
                    putCounter ++;
                if (callCounter >= callRows.size() || putCounter >= putRows.size()) break;
                if (callPrice[callCounter][2] == putPrice[putCounter][2] && callPrice[callCounter][2] > 0)
                    optPrice.add(new OptionPrice(callPrice[callCounter][0], callPrice[callCounter][1],
                            putPrice[putCounter][0], putPrice[putCounter][1], callPrice[callCounter][2]));
                callCounter ++;
                putCounter ++;
            }
        }
        catch (NullPointerException e) {
            fileFound = false;
        } catch (HttpStatusException e) {
            fileFound = false;
        } catch (IOException e) {
            fileFound = false;
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<OptionPrice> getPriceSeries() { return optPrice; }
    public boolean isFileFound() { return fileFound; }

}
