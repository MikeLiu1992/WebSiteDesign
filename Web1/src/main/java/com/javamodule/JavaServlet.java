package com.javamodule;

import com.javamodule.YahooAPI.YahooFinanceAPI;
import com.javamodule.object.InstPrice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(
        name = "JavaServlet",
        urlPatterns = "/stock-price"
)
public class JavaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String instrumentName = req.getParameter("InstName");
        String startDateStr = req.getParameter("start-date");
        String endDateStr = req.getParameter("end-date");
        if (instrumentName == null || instrumentName.equals("")|| instrumentName.contains("\n"))
            instrumentName = req.getParameter("InstNameHidden");
        if (startDateStr == null || startDateStr.equals("") || startDateStr.equals("MAX_DATE") || startDateStr.contains("\n"))
            startDateStr = req.getParameter("StartDateHidden");
        if (endDateStr == null || endDateStr.equals("") || endDateStr.equals("MAX_DATE") || endDateStr.contains("\n"))
            endDateStr = req.getParameter("EndDateHidden");
        if (instrumentName != null)
        {
            instrumentName.replaceAll("\\s+","");
            YahooFinanceAPI priceTable = new YahooFinanceAPI(instrumentName, startDateStr, endDateStr);
            if (priceTable.isFileFound())
            {
                ArrayList<InstPrice> priceList = priceTable.getPriceSeries();
                req.setAttribute("Price", priceList);
                req.setAttribute("InstrumentName", instrumentName);
                req.setAttribute("StartDate", startDateStr);
                req.setAttribute("EndDate", endDateStr);
                if (startDateStr == null || startDateStr.equals("") || startDateStr.equals("MAX_DATE"))
                    req.setAttribute("StartDate", "MAX_DATE");
                if (endDateStr == null || endDateStr.equals("") || endDateStr.equals("MAX_DATE"))
                    req.setAttribute("EndDate", "MAX_DATE");
                RequestDispatcher view = req.getRequestDispatcher("stock-price.jsp");
                view.forward(req, resp);
            }
            else
            {
                RequestDispatcher view = req.getRequestDispatcher("stock-price-welcome.jsp");
                view.forward(req, resp);
            }
        }
        else
        {
            RequestDispatcher view = req.getRequestDispatcher("stock-price-welcome.jsp");
            view.forward(req, resp);
        }
    }
}