package web6;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * http://localhost:8080/login
 * http://localhost:8080/logout
 * http://localhost:8080/who
 */
public class WebServer {
  public static void main(String[] args) throws Exception {

    ServletContextHandler handler = new ServletContextHandler();

    AuthService auth = new AuthService();
    LoginServlet loginServlet = new LoginServlet(auth);

    handler.addServlet(new ServletHolder(loginServlet), "/login");
    handler.addServlet(LogoutServlet.class, "/logout");
    handler.addServlet(WhoAmIServlet.class, "/who");

    Server server = new Server(8080);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
