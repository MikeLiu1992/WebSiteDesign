<%@ page import ="java.util.*" %>
<%@page import="com.javamodule.object.InstPrice"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.lang.reflect.Array" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

    <title>Equity Analysis</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/dashboard/">

    <!-- Bootstrap core CSS -->
    <link href="asset/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="asset/dashboard.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
    <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Equity Analysis</a>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <p><a href="https://finance.yahoo.com/" target="_blank">
            <img src="asset/Yahoo_Finance_Logo_1.png" height = "40px">
            </a></p>
        </li>
    </ul>
</nav>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <span data-feather="dollar-sign"></span>
                            Stock Price <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="option-price-welcome.jsp">
                            <span data-feather="activity"></span>
                            Option Price
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="security-pricer.jsp">
                            <span data-feather="tool"></span>
                            Security Pricer
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="trending-up"></span>
                            Implied Vol
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="bar-chart-2"></span>
                            Company Foundamental
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="layers"></span>
                            Technical Analysis
                        </a>
                    </li>
                </ul>

                <!--h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>Saved reports</span>
                    <a class="d-flex align-items-center text-muted" href="#">
                        <span data-feather="plus-circle"></span>
                    </a>
                </h6-->
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="about.jsp">
                            <span data-feather="user"></span>
                            About
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div>
                <%String instName = (String) request.getAttribute("InstrumentName");
                String startDate = (String) request.getAttribute("StartDate");
                if (startDate.equals("")) startDate = "MAX_DATE";
                String endDate = (String) request.getAttribute("EndDate");
                if (endDate.equals("")) endDate = "MAX_DATE";%>
                <p style="display: inline;"><%=instName%></p>
                <p style="display: inline;">Start Date: <%=startDate%></p>
                <p style="display: inline;">End Date: <%=endDate%></p>
                <div class="table-responsive">
                    <div id="DateObject">
                        <form method="post" action="stock-price">
                            <input type="text" placeholder="Search" aria-label="Search" id="InstName" name="InstName">
                            <input type="hidden" name="InstNameHidden" id="InstNameHidden" value=<%=instName%>>
                            <input type="hidden" name="StartDateHidden" id="StartDateHidden" value=<%=startDate%>>
                            <input type="hidden" name="EndDateHidden" id="EndDateHidden" value=<%=endDate%>>
                            <label>Start Date: </label>
                            <input type="date" id="start-date" name="start-date"/>
                            <label>End Date: </label>
                            <input type="date" id="end-date" name="end-date"/>
                            <input type="submit" value="Submit"/>
                        </form>
                    </div>
                    <div id='StockChart'></div>
                    <table id= "Stock-Price" class="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>Date</th>
                            <th>Open</th>
                            <th>Close</th>
                            <th>High</th>
                            <th>Low</th>
                            <th>AdjClose</th>
                            <th>Volume</th>
                        </tr>
                        </thead>
                        <tbody id="StockPrice">
                            <%
                                ArrayList<InstPrice> Prices = (ArrayList<InstPrice>) request.getAttribute("Price");
                                for(InstPrice prc : Prices){
                            %>
                            <tr>
                                <td><%=prc.getInstDate()%></td>
                                <td><%=prc.getOpen()%></td>
                                <td><%=prc.getClose()%></td>
                                <td><%=prc.getHigh()%></td>
                                <td><%=prc.getLow()%></td>
                                <td><%=prc.getAdjClose()%></td>
                                <td><%=prc.getVolume()%></td>
                                <%}%>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>

<!-- Icons -->
<script src="https://unpkg.com/feather-icons/dist/feather.min.js"></script>
<script>
    feather.replace()
</script>

<!-- Graphs -->
<script src='https://cdn.plot.ly/plotly-latest.min.js'></script>
<script src="asset/moment.jsp"></script>
<script>
    var closingPrices = document.querySelectorAll("#Stock-Price td");
    var dates = [];
    var closingPrice = [];
    for (var i = 0; i < closingPrices.length; i += 7)
    {
        dates.push(closingPrices[i].innerHTML);
        closingPrice.push(closingPrices[i + 5].innerHTML);
    }
    var data = [
    {
        x: dates,
        y: closingPrice,
        type: 'scatter'
    }
    ];

    Plotly.newPlot('StockChart', data);
</script>

</body>
</html>
