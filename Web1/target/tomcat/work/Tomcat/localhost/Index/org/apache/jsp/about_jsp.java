/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-06-26 19:41:24 UTC
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
import java.lang.reflect.Array;

public final class about_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <link rel=\"icon\" href=\"/docs/4.0/assets/img/favicons/favicon.ico\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lato\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
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
      out.write("    <ul class=\"navbar-nav px-3\">\r\n");
      out.write("        <li class=\"nav-item text-nowrap\">\r\n");
      out.write("            <p><a href=\"https://finance.yahoo.com/\" target=\"_blank\">\r\n");
      out.write("            <img src=\"asset/Yahoo_Finance_Logo_1.png\" height = \"40px\">\r\n");
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
      out.write("                            Stock Price <span class=\"sr-only\">(current)</span>\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"option-price-welcome.jsp\">\r\n");
      out.write("                            <span data-feather=\"activity\"></span>\r\n");
      out.write("                            Option Price\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link\" href=\"security-pricer.jsp\">\r\n");
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
      out.write("                <!--h6 class=\"sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted\">\r\n");
      out.write("                    <span>Saved reports</span>\r\n");
      out.write("                    <a class=\"d-flex align-items-center text-muted\" href=\"#\">\r\n");
      out.write("                        <span data-feather=\"plus-circle\"></span>\r\n");
      out.write("                    </a>\r\n");
      out.write("                </h6-->\r\n");
      out.write("                <ul class=\"nav flex-column mb-2\">\r\n");
      out.write("                    <li class=\"nav-item\">\r\n");
      out.write("                        <a class=\"nav-link active\" href=\"#\">\r\n");
      out.write("                            <span data-feather=\"user\"></span>\r\n");
      out.write("                            About\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </nav>\r\n");
      out.write("\r\n");
      out.write("        <main role=\"main\" class=\"col-md-9 ml-sm-auto col-lg-10 pt-3 px-4\">\r\n");
      out.write("            <div class=\"w3-content w3-container w3-padding-10\" id=\"about\">\r\n");
      out.write("                <h4 class=\"w3-center\">ABOUT ME</h4>\r\n");
      out.write("                <p class=\"w3-center\"><em>Financial Technology is the Key!</em></p>\r\n");
      out.write("                <p>I created this website as a playground for financial data. Data is provided by YahooFinance for free. However,\r\n");
      out.write("                it should not be used for any commercial purpose. This website can be used for as a starting point for anyone passionate\r\n");
      out.write("                about finance and would like to get some exposure to some industry technique like finianical analysis and derivative\r\n");
      out.write("                    pricing.</p>\r\n");
      out.write("                <div class=\"w3-row\">\r\n");
      out.write("                    <!-- Hide this text on small devices -->\r\n");
      out.write("                    <div class=\"w3-col m6 w3-hide-small w3-padding-16\">\r\n");
      out.write("                        <p>I am a typical Wall Street desk Quant dealing with data and model everyday and I believe technology is the key to\r\n");
      out.write("                            financial innovation. I want to use this website as a playground for parsing and processing financial data and\r\n");
      out.write("                            try out various techniques in the industry. I am always welcome to feedback and let me know your thoughts!\r\n");
      out.write("                        </p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"w3-col m6 w3-center w3-padding-16\">\r\n");
      out.write("                        <p><b><i class=\"fa fa-user w3-margin-left\"></i>Michael Liu</b></p>\r\n");
      out.write("                        <img src=\"asset/avatar.jpg\" class=\"w3-circle w3-image w3-opacity w3-hover-opacity-off\" alt=\"Photo of Me\" width=\"125\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"w3-content w3-container w3-padding-64\" id=\"contact\">\r\n");
      out.write("                <h3 class=\"w3-center\">WHERE I WORK</h3>\r\n");
      out.write("                <p class=\"w3-center\"><em>I'd love your feedback!</em></p>\r\n");
      out.write("                <div class=\"w3-col m4 w3-container\">\r\n");
      out.write("                    <img src=\"asset/New_York_City.jpg\" class=\"w3-image w3-round\" style=\"width:75%\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"w3-col m8 w3-panel\">\r\n");
      out.write("                    <div class=\"w3-large w3-margin-bottom\">\r\n");
      out.write("                        <i class=\"fa fa-map-marker fa-fw w3-hover-text-black w3-xlarge w3-margin-right\"></i> New York City, US<br>\r\n");
      out.write("                        <i class=\"fa fa-envelope fa-fw w3-hover-text-black w3-xlarge w3-margin-right\"></i> mikefinancialanalysis@gmail.com<br>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <form action=\"EmailSendingServlet\" method=\"post\">\r\n");
      out.write("                    <div class=\"w3-row-padding\" style=\"margin:0 -16px 8px -16px\">\r\n");
      out.write("                        <div class=\"w3-half\">\r\n");
      out.write("                            <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Name\" required name=\"Name\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"w3-half\">\r\n");
      out.write("                            <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Email\" required name=\"Email\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <input class=\"w3-input w3-border\" type=\"text\" placeholder=\"Message\" required name=\"eMessage\">\r\n");
      out.write("                    <input class=\"w3-button w3-black w3-right w3-section\" type=\"submit\" value=\"SEND MESSAGE\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"w3-xlarge w3-section\">\r\n");
      out.write("                <a href =\"https://www.linkedin.com/in/yanxiong-michael-liu-cfa-1673177b/ \">\r\n");
      out.write("                    <i class=\"fa fa-linkedin fa-fw w3-hover-text-black w3-xlarge w3-margin-right\"></i>\r\n");
      out.write("                </a>\r\n");
      out.write("                <a href =\"https://github.com/MikeLiu1992/ \">\r\n");
      out.write("                    <i class=\"fa fa-github fa-fw w3-hover-text-black w3-xlarge w3-margin-right\"></i>\r\n");
      out.write("                </a>\r\n");
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
