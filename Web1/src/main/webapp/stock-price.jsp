<%@ page import ="java.util.*" %>
<%@page import="com.sample.InstPrice"%>
<%@page import="java.util.ArrayList"%>
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
    <form class="form-control form-control-dark w-100" method="post" action="stock-price">
        <input type="text" placeholder="Search" aria-label="Search" id="inst-name" name="inst-name">
        <input type="submit" value="Submit" style="display: none"/>
    </form>
    <ul class="navbar-nav px-3">
        <li class="nav-item text-nowrap">
            <img src="asset/Yahoo_Finance_Logo_1.png" height = "55px">
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
                            <span data-feather="home"></span>
                            Stock Price <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file"></span>
                            Option Price
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="shopping-cart"></span>
                            Security Pricer
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="users"></span>
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
                            <span data-feather="file-text"></span>
                            Current month
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Last quarter
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Social engagement
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Year-end sale
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div>
                <h2>Stock Price</h2>
                <div class="table-responsive">
                    <canvas class="my-4" id="StockChart" width="900" height="380"></canvas>
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
                            for(InstPrice prc : Prices){%>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.1/Chart.min.js"></script>
<script src="asset/moment.jsp"></script>
<script>
    var ctx = document.getElementById('StockChart').getContext('2d');
    var closingPrice = document.querySelectorAll("#Stock-Price td");
    var StockChart = new Chart(ctx, {
        type: 'line',
        data: {
            datasets: [{
                label: 'Stock Price',
                pointRadius: 0.5,
                fill: true,
                lineTension: 0,
                borderWidth: 2,
                fillColor: "red",
                data: [{
                    x: 1,
                    y: parseFloat(closingPrice[5].innerHTML)
                }]
            }],
        },
        options: {
            scales: {
                xAxes: [{
                    type: 'linear',
                    position: 'bottom'
                }]
            }
        }
    });
    var i = 1;
    for (var j = 12; j < closingPrice.length; j ++)
    {
        if (j % 7 == 5)
        {
            StockChart.data.datasets.forEach((dataset) => {
                dataset.data.push({x: i,
                    y: parseFloat(closingPrice[j].innerHTML)})
            });
            i = i + 1;
            StockChart.update();
        }
    }
</script>
</body>
</html>
