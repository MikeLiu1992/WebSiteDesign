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

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#tabs" ).tabs();
        } );
    </script>

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
                            <a class="nav-link" href="option-price-welcome.jsp">
                                <span data-feather="activity"></span>
                                Option Price <span class="sr-only"></span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <span data-feather="tool">(current)</span>
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
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link" id="home-tab" data-toggle="tab" href="security-pricer.jsp" role="tab" aria-controls="home" aria-selected="true">European</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="profile-tab" data-toggle="tab" href="america.jsp" role="tab" aria-controls="profile" aria-selected="false">American</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" id="contact-tab" data-toggle="tab" href="#" role="tab" aria-controls="contact" aria-selected="false">MonteCarlo</a>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <h3>MonteCarlo</h3>
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
</body>
</html>
