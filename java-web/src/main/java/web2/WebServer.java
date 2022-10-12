package web2;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;

/**
 * http://localhost:8080/calc
 * http://localhost:8080/hello
 * http://localhost:8080/home
 */
public class WebServer {
  public static void main(String[] args) throws Exception {

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(CalcServlet.class, "/calc");
    handler.addServlet(HelloServlet.class, "/hello");
    handler.addServlet("web2.HomeServlet", "/home");

    String whereTo = "/hello";
    Servlet redirectServlet = new RedirectServlet(whereTo);
    ServletHolder servletWrapped = new ServletHolder(redirectServlet);
    handler.addServlet(servletWrapped, "/*");

    Server server = new Server(8080);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
