package com.sample;

import com.sample.model.InstrumentName;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class YahooFinanceAPI {

    private ArrayList<InstPrice> priceSeries = new ArrayList<InstPrice>();

    public YahooFinanceAPI(String args) throws IOException {

        YahooAddress APIAddress = new YahooAddress(args);
        URL url = new URL(APIAddress.getFinalAddress());
        URLConnection connection = url.openConnection();

        InputStreamReader input = new InputStreamReader(connection.getInputStream());
        BufferedReader buffer = null;
        String line = "";
        String csvSplitBy = ",";
        try {

            buffer = new BufferedReader(input);
            buffer.readLine();
            while ((line = buffer.readLine()) != null) {
                String[] room = line.split(csvSplitBy);
                String instDate = room[0];
                double open = Double.parseDouble(room[1]);
                double close = Double.parseDouble(room[4]);
                double low = Double.parseDouble(room[3]);
                double high = Double.parseDouble(room[2]);
                double adjClose = Double.parseDouble(room[5]);
                long volume = Long.parseLong(room[6]);
                priceSeries.add(new InstPrice(instDate, open, close, low, high, adjClose, volume));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ArrayList<InstPrice> getPriceSeries() { return priceSeries; }

}
