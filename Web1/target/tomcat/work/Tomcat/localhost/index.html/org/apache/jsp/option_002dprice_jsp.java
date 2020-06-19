/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-18 16:09:49 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.javamodule.object.InstPrice;
import java.util.ArrayList;
import com.javamodule.object.OptionPrice;
import com.javamodule.object.DateObject;

public final class option_002dprice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"icon\" href=\"/docs/4.0/assets/img/favicons/favicon.ico\">\r\n");
      out.write("\r\n");
      out.write("    <title>Equity Analysis</title>\r\n");
      out.write("\r\n");
      out.write("    <link rel=\"canonical\" href=\"https://getbootstrap.com/docs/4.0/examples/dashboard/\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("    <link href=\"asset/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- Custom styles for this template -->\r\n");
      out.write("    <link href=\"asset/dashboard.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<nav class=\"navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0\">\r\n");
      out.write("    <a class=\"navbar-brand col-sm-3 col-md-2 mr-0\" href=\"#\">Equity Analysis</a>\r\n");
      out.write("    <form class=\"form-control form-control-dark w-100\" method=\"post\" action=\"option-price\">\r\n");
      out.write("        <input type=\"text\" placeholder=\"Search\" aria-label=\"Search\" id=\"inst-name-option\" name=\"inst-name-option\">\r\n");
      out.write("        <input type=\"submit\" value=\"Submit\" style=\"display: none\"/>\r\n");
      out.write("    </form>\r\n");
      out.write("    <ul class=\"navbar-nav px-3\">\r\n");
      out.write("        <li class=\"nav-item text-nowrap\">\r\n");
      out.write("            <p><a href=\"https://finance.yahoo.com/\" target=\"_blank\">\r\n");
      out.write("                <img src=\"asset/Yahoo_Finance_Logo_1.png\" height = \"40px\" alt=\"centered image\">\r\n");
      out.write("            </a></p>\r\n");
      out.write("        </li>\r\n");
      out.write("    </ul>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"row\">\r\n");
      out.write("        <nav class=\"col-md-2 d-none d-md-block bg-light sidebar\">\r\n");
      out.write("            <div class=\"sidebar-sticky\">\r\n");
      out.write("                <ul class=\"nav flex-column\">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"stock-price-welcome.jsp\">\r\n");
      out.write("                            <span data-feather=\"dollar-sign\"></span>\r\n");
      out.write("                            Stock Price\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link active\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"activity\"></span>\r\n");
      out.write("                            Option Price <span class=\"sr-only\">(current)</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"tool\"></span>\r\n");
      out.write("                            Security Pricer\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"trending-up\"></span>\r\n");
      out.write("                            Implied Vol\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"bar-chart-2\"></span>\r\n");
      out.write("                            Company Foundamental\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"layers\"></span>\r\n");
      out.write("                            Technical Analysis\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                <h6 class=\"sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted\">\r\n");
      out.write("                    <span>Saved reports</span>\r\n");
      out.write("                    <a class=\"d-flex align-items-center text-muted\" href=\"#\">\r\n");
      out.write("                        <span data-feather=\"plus-circle\"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </h6>\r\n");
      out.write("                <ul class=\"nav flex-column mb-2\">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"user\"></span>\r\n");
      out.write("                            Developer\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"file-text\"></span>\r\n");
      out.write("                            Disclaimer\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <main role=\"main\" class=\"col-md-9 ml-sm-auto col-lg-10 pt-3 px-4\">\r\n");
      out.write("            <div>\r\n");
      out.write("                <form method=\"post\" action=\"option-price\">\r\n");
      out.write("                <div class=\"exp-select\" style=\"width:400px;\">\r\n");
      out.write("                    ");
ArrayList<String> instName = (ArrayList<String>) request.getAttribute("InstNameOption");
                    ArrayList<String> expirationName = (ArrayList<String>) request.getAttribute("CurrentExpDate");
      out.write("\r\n");
      out.write("                    <input type=\"hidden\" name=\"InstNameOption\" id=\"InstNameOption\" value=");
      out.print(instName.get(0));
      out.write(">\r\n");
      out.write("                    <p style=\"display: inline; margin-right: 6px;\">Underlying: ");
      out.print(instName.get(0));
      out.write("</p>\r\n");
      out.write("                    <p style=\"display: inline; margin-right: 6px;\">Expiration: ");
      out.print(expirationName.get(0));
      out.write("</p>\r\n");
      out.write("                    <select id=\"expDates\" name=\"expDates\">\r\n");
      out.write("                            <option value=\"0\">Select Expiration:</option>\r\n");
      out.write("                        ");

                            ArrayList<DateObject> Dates = (ArrayList<DateObject>) request.getAttribute("ExpDate");
                            for(DateObject SingleDate : Dates){
                        
      out.write("\r\n");
      out.write("                            <option value=");
      out.print(SingleDate.getEpochFormat());
      out.write('>');
      out.print(SingleDate.getDateFormat());
      out.write("</option>\r\n");
      out.write("                        ");
}
      out.write("\r\n");
      out.write("                    </select><input type=\"submit\" value=\"Submit\" class=\"custom-inline-block\">\r\n");
      out.write("                </div>\r\n");
      out.write("                </form>\r\n");
      out.write("                <div class=\"table-responsive\">\r\n");
      out.write("                    <div id='OptionChart'></div>\r\n");
      out.write("                    <table id= \"Option-Price\" class=\"table table-striped table-sm\">\r\n");
      out.write("                        <thead>\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <th>CallBidPrice</th>\r\n");
      out.write("                            <th>CallAskPrice</th>\r\n");
      out.write("                            <th>Strike</th>\r\n");
      out.write("                            <th>PutBidPrice</th>\r\n");
      out.write("                            <th>PutAskPrice</th>\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        </thead>\r\n");
      out.write("                        <tbody id=\"OptionPrice\">\r\n");
      out.write("                        ");

                            ArrayList<OptionPrice> Prices = (ArrayList<OptionPrice>) request.getAttribute("OptionPrice");
                            for(OptionPrice prc : Prices){
                        
      out.write("\r\n");
      out.write("                        <tr>\r\n");
      out.write("                            <td>");
      out.print(prc.getCallBid());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(prc.getCallAsk());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(prc.getStrike());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(prc.getPutBid());
      out.write("</td>\r\n");
      out.write("                            <td>");
      out.print(prc.getPutAsk());
      out.write("</td>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </tr>\r\n");
      out.write("                        </tbody>\r\n");
      out.write("                    </table>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </main>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap core JavaScript\r\n");
      out.write("================================================== -->\r\n");
      out.write("<!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script>window.jQuery || document.write('<script src=\"../../assets/js/vendor/jquery-slim.min.js\"><\\/script>')</script>\r\n");
      out.write("<script src=\"../../assets/js/vendor/popper.min.js\"></script>\r\n");
      out.write("<script src=\"../../dist/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!-- Icons -->\r\n");
      out.write("<script src=\"https://unpkg.com/feather-icons/dist/feather.min.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    feather.replace()\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("!-- Graphs -->\r\n");
      out.write("<script src='https://cdn.plot.ly/plotly-latest.min.js'></script>\r\n");
      out.write("<script src=\"asset/moment.jsp\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("    var lastPrice = document.querySelectorAll(\"#Option-Price td\");\r\n");
      out.write("    var strike = [];\r\n");
      out.write("    var callBid = [];\r\n");
      out.write("    var callAsk = [];\r\n");
      out.write("    var putBid = [];\r\n");
      out.write("    var putAsk = [];\r\n");
      out.write("    for (var i = 0; i < lastPrice.length - 5; i += 5 )\r\n");
      out.write("    {\r\n");
      out.write("        callBid.push(lastPrice[i].innerHTML);\r\n");
      out.write("        callAsk.push(lastPrice[i + 1].innerHTML);\r\n");
      out.write("        strike.push(lastPrice[i + 2].innerHTML);\r\n");
      out.write("        putBid.push(lastPrice[i + 3].innerHTML);\r\n");
      out.write("        putAsk.push(lastPrice[i + 4].innerHTML);\r\n");
      out.write("    }\r\n");
      out.write("    var data1 =\r\n");
      out.write("        {\r\n");
      out.write("            x: strike,\r\n");
      out.write("            y: callBid,\r\n");
      out.write("            type: 'line',\r\n");
      out.write("            name: 'Call Bid',\r\n");
      out.write("            marker: {line: {width: 0.25}}\r\n");
      out.write("        };\r\n");
      out.write("    var data2 =\r\n");
      out.write("        {\r\n");
      out.write("            x: strike,\r\n");
      out.write("            y: callAsk,\r\n");
      out.write("            type: 'line',\r\n");
      out.write("            name: 'Call Ask',\r\n");
      out.write("            marker: {line: {width: 0.25}}\r\n");
      out.write("        };\r\n");
      out.write("    var data3 =\r\n");
      out.write("        {\r\n");
      out.write("            x: strike,\r\n");
      out.write("            y: putBid,\r\n");
      out.write("            type: 'line',\r\n");
      out.write("            name: 'Put Bid',\r\n");
      out.write("            marker: {line: {width: 0.25}}\r\n");
      out.write("        };\r\n");
      out.write("    var data4 =\r\n");
      out.write("        {\r\n");
      out.write("            x: strike,\r\n");
      out.write("            y: putAsk,\r\n");
      out.write("            type: 'line',\r\n");
      out.write("            name: 'Put Ask',\r\n");
      out.write("            marker: {line: {width: 0.25}}\r\n");
      out.write("        };\r\n");
      out.write("    var data = [data1, data2, data3, data4];\r\n");
      out.write("    Plotly.newPlot('OptionChart', data);\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
