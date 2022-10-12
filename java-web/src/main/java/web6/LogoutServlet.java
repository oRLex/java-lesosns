package web6;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
    Optional<Cookie> oc = CookieHelpers.read(rq);
    try (PrintWriter w = rs.getWriter()) {
      oc.ifPresent(c -> {
        c.setMaxAge(0);
        rs.addCookie(c);
        w.printf("User %s logged out", c.getValue());
      });

      if (!oc.isPresent()) {
        w.println("No logged user in the system");
      }
    }
  }

}
