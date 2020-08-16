<%@ page import ="java.util.*" %>
<%@page import="com.javamodule.object.InstPrice"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="com.javamodule.object.OptionPrice" %>
<%@ page import="com.javamodule.object.DateObject" %>
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
    <form class="form-control form-control-dark w-100" method="post" action="option-price">
        <input type="text" placeholder="Search" aria-label="Search" id="inst-name-option" name="inst-name-option">
        <input type="submit" value="Submit" style="display: none"/>
    </form>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <p><a href="https://finance.yahoo.com/" target="_blank">
                <img src="asset/Yahoo_Finance_Logo_1.png" height = "40px" alt="centered image">
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
                        <a class="nav-link" href="stock-price-welcome.jsp">
                            <span data-feather="dollar-sign"></span>
                            Stock Price
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <span data-feather="activity"></span>
                            Option Price <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
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

                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>Saved reports</span>
                    <a class="d-flex align-items-center text-muted" href="#">
                        <span data-feather="plus-circle"></span>
                    </a>
                </h6>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="user"></span>
                            Developer
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Disclaimer
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div>
                <form method="post" action="option-price">
                <div class="exp-select" style="width:400px;">
                    <%ArrayList<String> instName = (ArrayList<String>) request.getAttribute("InstNameOption");
                    ArrayList<String> expirationName = (ArrayList<String>) request.getAttribute("CurrentExpDate");%>
                    <input type="hidden" name="InstNameOption" id="InstNameOption" value=<%=instName.get(0).toUpperCase()%>>
                    <p style="display: inline; margin-right: 6px;">Underlying: <%=instName.get(0)%></p>
                    <p style="display: inline; margin-right: 6px;">Expiration: <%=expirationName.get(0)%></p>
                    <select id="expDates" name="expDates">
                            <option value="0">Select Expiration:</option>
                        <%
                            ArrayList<DateObject> Dates = (ArrayList<DateObject>) request.getAttribute("ExpDate");
                            for(DateObject SingleDate : Dates){
                        %>
                            <option value=<%=SingleDate.getEpochFormat()%>><%=SingleDate.getDateFormat()%></option>
                        <%}%>
                    </select><input type="submit" value="Submit" class="custom-inline-block">
                </div>
                </form>
                <div class="table-responsive">
                    <div id='OptionChart'></div>
                    <table id= "Option-Price" class="table table-striped table-sm">
                        <thead>
                        <tr>
                            <th>CallBidPrice</th>
                            <th>CallAskPrice</th>
                            <th>Strike</th>
                            <th>PutBidPrice</th>
                            <th>PutAskPrice</th>
                        </tr>
                        </thead>
                        <tbody id="OptionPrice">
                        <%
                            ArrayList<OptionPrice> Prices = (ArrayList<OptionPrice>) request.getAttribute("OptionPrice");
                            for(OptionPrice prc : Prices){
                        %>
                        <tr>
                            <td><%=prc.getCallBid()%></td>
                            <td><%=prc.getCallAsk()%></td>
                            <td><%=prc.getStrike()%></td>
                            <td><%=prc.getPutBid()%></td>
                            <td><%=prc.getPutAsk()%></td>
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

!-- Graphs -->
<script src='https://cdn.plot.ly/plotly-latest.min.js'></script>
<script src="asset/moment.jsp"></script>
<script>
    var lastPrice = document.querySelectorAll("#Option-Price td");
    var strike = [];
    var callBid = [];
    var callAsk = [];
    var putBid = [];
    var putAsk = [];
    for (var i = 0; i < lastPrice.length - 5; i += 5 )
    {
        callBid.push(lastPrice[i].innerHTML);
        callAsk.push(lastPrice[i + 1].innerHTML);
        strike.push(lastPrice[i + 2].innerHTML);
        putBid.push(lastPrice[i + 3].innerHTML);
        putAsk.push(lastPrice[i + 4].innerHTML);
    }
    var data1 =
        {
            x: strike,
            y: callBid,
            type: 'line',
            name: 'Call Bid',
            marker: {line: {width: 0.25}}
        };
    var data2 =
        {
            x: strike,
            y: callAsk,
            type: 'line',
            name: 'Call Ask',
            marker: {line: {width: 0.25}}
        };
    var data3 =
        {
            x: strike,
            y: putBid,
            type: 'line',
            name: 'Put Bid',
            marker: {line: {width: 0.25}}
        };
    var data4 =
        {
            x: strike,
            y: putAsk,
            type: 'line',
            name: 'Put Ask',
            marker: {line: {width: 0.25}}
        };
    var data = [data1, data2, data3, data4];
    Plotly.newPlot('OptionChart', data);
</script>
</body>
</html>
