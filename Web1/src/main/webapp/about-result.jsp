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
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

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
                        <a class="nav-link" href="stock-price-welcome.jsp">
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
                        <a class="nav-link active" href="#">
                            <span data-feather="user"></span>
                            About
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
            <div class="w3-content w3-container w3-padding-10" id="about">
                <h3 class="w3-center">ABOUT ME</h3>
                <p class="w3-center"><em>Financial Technology is the Key!</em></p>
                <p>I created this website as a playground for financial data. Data is provided by YahooFinance for free. However,
                    it should not be used for any commercial purpose. This website can be used for as a starting point for anyone passionate
                    about finance and would like to get some exposure to some industry technique like finianical analysis and derivative
                    pricing.</p>
                <div class="w3-row">
                   <!-- Hide this text on small devices -->
                    <div class="w3-col m6 w3-center w3-padding-large">
                        <p><b><i class="fa fa-user w3-margin-right"></i>Michael Liu</b></p><br>
                        <img src="asset/avatar.jpg" class="w3-round w3-image w3-opacity w3-hover-opacity-off" alt="Photo of Me" width="125">
                    </div>
                    <div class="w3-col m6 w3-hide-small w3-padding-large">
                        <p>I am a typical Wall Street desk Quant dealing with data and model everyday and I believe technology is the key to
                            financial innovation. I want to use this website as a playground for parsing and processing financial data and
                            try out various techniques in the industry. I am always welcome to feedback and let me know your thoughts!
                        </p>
                    </div>
                </div>
            </div>
            <div class="w3-content w3-container w3-padding-64" id="contact">
                <h3 class="w3-center">WHERE I WORK</h3>
                <p class="w3-center"><em>I'd love your feedback!</em></p>
                <div class="w3-col m4 w3-container">
                    <img src="asset/New_York_City.jpg" class="w3-image w3-round" style="width:75%">
                </div>
                <div class="w3-col m8 w3-panel">
                    <div class="w3-large w3-margin-bottom">
                        <i class="fa fa-map-marker fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i> New York City, US<br>
                        <i class="fa fa-envelope fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i> Email: mikefinancialanalysis@gmail.com<br>
                    </div>
                </div>
                <form action="EmailSendingServlet" method="post">
                    <div class="w3-row-padding" style="margin:0 -16px 8px -16px">
                        <div class="w3-half">
                            <input class="w3-input w3-border" type="text" placeholder="Name" required name="Name">
                        </div>
                        <div class="w3-half">
                            <input class="w3-input w3-border" type="text" placeholder="Email" required name="Email">
                        </div>
                    </div>
                    <input class="w3-input w3-border" type="text" placeholder="Message" required name="eMessage">
                    <input class="w3-button w3-black w3-right w3-section" type="submit" value="SEND MESSAGE">
                    <p><%=request.getAttribute("Message")%></p>
                </form>
            </div>
            <div class="w3-xlarge w3-section">
                <a href ="https://www.linkedin.com/in/yanxiong-michael-liu-cfa-1673177b/ ">
                    <i class="fa fa-linkedin fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
                </a>
                <a href ="https://github.com/MikeLiu1992/ ">
                    <i class="fa fa-github fa-fw w3-hover-text-black w3-xlarge w3-margin-right"></i>
                </a>
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

</body>
</html>
