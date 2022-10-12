package web7;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import web2.TemplateEngine;

import javax.servlet.DispatcherType;
import javax.servlet.MultipartConfigElement;
import java.util.EnumSet;

public class Application {

  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);

    TemplateEngine te = TemplateEngine.folder("navi_app");
    Authentication auth = new Authentication();
    Calculator calc = new Calculator();
    ServletContextHandler handler = new ServletContextHandler();
//    handler.addServlet(new ServletHolder(new UploadServlet(te)), "/upload");

    ServletHolder h = new ServletHolder(new UploadServlet(te));
    handler.addServlet(h, "/upload/*");
    h.getRegistration().setMultipartConfig(new MultipartConfigElement("./from_user"));

    handler.addServlet(new ServletHolder(new CalcServlet(te, calc)), "/calc");
    handler.addServlet(new ServletHolder(new LoginServlet(te, auth)), "/login");
    handler.addServlet(new ServletHolder(new LogoutServlet()), "/logout");
    handler.addServlet(new ServletHolder(new RootServlet()), "/menu");
    handler.addServlet(new ServletHolder(new RedirectServlet()), "/*");

    handler.addFilter(LoggingFilter.class, "/*", EnumSet.of(DispatcherType.REQUEST));
    handler.addFilter(CookieFilter.class, "/calc", EnumSet.of(DispatcherType.REQUEST));
//    handler.addFilter(new FilterHolder(new CookieFilter()), "/calc", EnumSet.of(DispatcherType.REQUEST));

    server.setHandler(handler);

    server.start();
    server.join();
  }

}
