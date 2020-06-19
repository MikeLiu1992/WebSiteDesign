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
import java.util.ArrayList;

@WebServlet(
        name = "JavaServlet",
        urlPatterns = "/stock-price"
)
public class JavaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String instrumentName = req.getParameter("inst-name");
        String startDateStr = req.getParameter("start-date");
        String endDateStr = req.getParameter("end-date");
        if (instrumentName == null)
            instrumentName = req.getParameter("InstNameHidden");
        System.out.println(instrumentName);
        System.out.println(startDateStr);
        System.out.println(endDateStr);
        if (instrumentName != null)
        {
            instrumentName.replaceAll("\\s+","");
            YahooFinanceAPI priceTable = new YahooFinanceAPI(instrumentName, startDateStr, endDateStr);
            if (priceTable.isFileFound())
            {
                ArrayList<InstPrice> priceList = priceTable.getPriceSeries();
                req.setAttribute("Price", priceList);
                req.setAttribute("InstrumentName", instrumentName);
                RequestDispatcher view = req.getRequestDispatcher("stock-price.jsp");
                view.forward(req, resp);
            }
            else
            {
                ArrayList<InstPrice> priceList = new ArrayList<>();
                req.setAttribute("Price", priceList);
                req.setAttribute("InstrumentName", instrumentName);
                RequestDispatcher view = req.getRequestDispatcher("stock-price-welcome.jsp");
                view.forward(req, resp);
            }
        }
    }
}