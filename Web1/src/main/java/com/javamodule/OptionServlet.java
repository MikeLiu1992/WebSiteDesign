package com.javamodule;

import com.javamodule.YahooAPI.YahooFinanceOptionAPI;
import com.javamodule.object.DateObject;
import com.javamodule.object.OptionPrice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

@WebServlet(
        name = "OptionServlet",
        urlPatterns = "/option-price"
)
public class OptionServlet extends HttpServlet {

    public String convertToNormalDate(String epochValue)
    {
        long temp = (Long.parseLong(epochValue) + 24 * 3600)* 1000;
        DateFormat format = new SimpleDateFormat("MMMM dd, yyyy");
        String formatted = format.format(temp);
        return formatted;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            ArrayList<String> expirationString = new ArrayList<String>();
            String tempStringDate = new String();
            String instrumentOptionName = req.getParameter("inst-name-option");
            ArrayList<String> instNames = new ArrayList<String>();
            ArrayList<OptionPrice> priceList = new ArrayList<OptionPrice>();
            ArrayList<DateObject> expList = new ArrayList<DateObject>();
            YahooFinanceOptionAPI priceTable = new YahooFinanceOptionAPI();


            if (instrumentOptionName == null)
            {
                instrumentOptionName = req.getParameter("InstNameOption");
                instrumentOptionName.replaceAll("\\s+","");
                tempStringDate = req.getParameter("expDates");
                expirationString.add(convertToNormalDate(tempStringDate));
                priceTable = new YahooFinanceOptionAPI(instrumentOptionName, tempStringDate);
            }
            else
            {
                instrumentOptionName.replaceAll("\\s+","");
                priceTable = new YahooFinanceOptionAPI(instrumentOptionName);
            }


            if (priceTable.isFileFound())
            {
                priceList = priceTable.getPriceSeries();
                expList = priceTable.getDateList();
            }
            if (expirationString.size() == 0)
                expirationString.add(expList.get(0).getDateFormat());
            instNames.add(instrumentOptionName);
            req.setAttribute("InstNameOption", instNames);
            req.setAttribute("OptionPrice", priceList);
            req.setAttribute("ExpDate", expList);
            if (priceTable.isFileFound())
            {
                req.setAttribute("CurrentExpDate", expirationString);
                RequestDispatcher view = req.getRequestDispatcher("option-price.jsp");
                view.forward(req, resp);
            }
            else {
                RequestDispatcher view = req.getRequestDispatcher("option-price-welcome.jsp");
                view.forward(req, resp);
            }
        }
    }