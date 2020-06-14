package com.sample;

import com.sample.model.InstrumentName;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet(
        name = "JavaServlet",
        urlPatterns = "/stock-price"
)
public class JavaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String instrumentName = req.getParameter("inst-name");
        instrumentName.replaceAll("\\s+","");
        YahooFinanceAPI priceTable = new YahooFinanceAPI(instrumentName);
        ArrayList<InstPrice> priceList = priceTable.getPriceSeries();

        req.setAttribute("Price", priceList);
        RequestDispatcher view = req.getRequestDispatcher("stock-price.jsp");
        view.forward(req, resp);

    }
}