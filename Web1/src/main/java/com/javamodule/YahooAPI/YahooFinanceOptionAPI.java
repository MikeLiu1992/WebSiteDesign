package com.javamodule.YahooAPI;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import com.javamodule.object.DateObject;
import com.javamodule.object.OptionPrice;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class YahooFinanceOptionAPI {

    private ArrayList<OptionPrice> optPrice = new ArrayList<OptionPrice>();
    private ArrayList<DateObject> dataList = new ArrayList<>();
    private boolean fileFound = true;

    public double stringConversion(String str) throws ParseException {
        str = str.replaceAll(",","");
        if (str == "")
            return 0;
        return Double.parseDouble(str);
    }

    public YahooFinanceOptionAPI(){}

    public YahooFinanceOptionAPI(String args) throws IOException {
        YahooOptionAddress url = new YahooOptionAddress(args);
        try {
            Document doc = Jsoup.connect(url.getFinalAddress()).get();
            expDateList(url, doc);
            Element callTables = doc.select(url.getCallSelector()).first();
            Element putTables= doc.select(url.getPutSelector()).first();
            Elements callRows = callTables.select("tr");
            Elements putRows = putTables.select("tr");
            double [][] callPrice = new double[callRows.size()][3];
            double [][] putPrice = new double[putRows.size()][3];

            for (int i = 0; i < callRows.size(); i++) {
                Element row = callRows.get(i);
                Elements cols = row.select("td");
                if ( cols.size() > 6 && !cols.get(4).text().equals("-") && !cols.get(5).text().equals("-"))
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
                if ( cols.size() > 6 && !cols.get(4).text().contains("-") && !cols.get(5).text().contains("-"))
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

    public YahooFinanceOptionAPI(String args, String expDate) throws IOException {
        YahooOptionAddress url = new YahooOptionAddress(args, expDate);
        try {
            Document doc = Jsoup.connect(url.getFinalAddress()).get();
            expDateList(url, doc);
            Element callTables = doc.select(url.getCallSelector()).first();
            Element putTables= doc.select(url.getPutSelector()).first();
            Elements callRows = callTables.select("tr");
            Elements putRows = putTables.select("tr");
            double [][] callPrice = new double[callRows.size()][3];
            double [][] putPrice = new double[putRows.size()][3];

            for (int i = 0; i < callRows.size(); i++) {
                Element row = callRows.get(i);
                Elements cols = row.select("td");
                if ( cols.size() > 0 && !cols.get(4).text().equals("-") && !cols.get(5).text().equals("-"))
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
                if ( cols.size() > 0 && !cols.get(4).text().contains("-") && !cols.get(5).text().contains("-"))
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

    public void expDateList(YahooOptionAddress url, Document doc) throws IOException, ParseException {
        Element expTables = doc.select(url.getExpSelector()).first();
        Elements rows = expTables.select("select");
        for (int i = 0; i < rows.size(); i ++)
        {
            Element row = rows.get(i);
            Elements cols = row.select("option");
            for (int j = 0; j < cols.size(); j ++)
            {
                DateObject newDates = new DateObject(cols.get(j).text(), cols.get(j).attr("value"));
                dataList.add(newDates);
            }
        }
    }

    public ArrayList<OptionPrice> getPriceSeries() { return optPrice; }
    public ArrayList<DateObject> getDateList() { return dataList; }
    public boolean isFileFound() { return fileFound; }

}
