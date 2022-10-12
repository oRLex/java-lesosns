package web6;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class WhoAmIServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
    Optional<Cookie> oc = CookieHelpers.read(rq);
    try (PrintWriter w = rs.getWriter()) {
      if (oc.isPresent()) {
        w.printf("I'm %s", oc.get().getValue());
      } else {
        w.println("No logged user in the system");
      }
    }
  }
}
