package com.sample;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        name = "OptionServlet",
        urlPatterns = "/option-price"
)
public class OptionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String instrumentOptionName = req.getParameter("inst-name-option");
            instrumentOptionName.replaceAll("\\s+","");
            YahooFinanceOptionAPI priceTable = new YahooFinanceOptionAPI(instrumentOptionName);
            if (priceTable.isFileFound())
            {
                ArrayList<OptionPrice> priceList = priceTable.getPriceSeries();
                req.setAttribute("OptionPrice", priceList);
                RequestDispatcher view = req.getRequestDispatcher("option-price.jsp");
                view.forward(req, resp);
            }
            else
            {
                ArrayList<OptionPrice> priceList = new ArrayList<OptionPrice>();
                req.setAttribute("OptionPrice", priceList);
                RequestDispatcher view = req.getRequestDispatcher("option-price-welcome.jsp");
                view.forward(req, resp);
            }
    }
}