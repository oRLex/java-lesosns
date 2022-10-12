package web6;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

  private final AuthService auth;
  private final boolean rememberMe = true;

  private int timeNormal = 60 * 60; // 1h
  private int timeRemember = timeNormal * 24; // 1d

  public LoginServlet(AuthService auth) {
    this.auth = auth;
  }

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
    Optional<Cookie> oc = CookieHelpers.read(rq);
    try (PrintWriter w = rs.getWriter()) {
      if (oc.isPresent()) {
        w.printf("User already identified: %s", oc.get().getValue());
      } else {
        String nextId = auth.getNextString();
        Cookie c = new Cookie(CookieHelpers.cookieName, nextId);
        c.setMaxAge(rememberMe ? timeRemember : timeNormal);
        c.setPath("/");
        rs.addCookie(c);
        w.printf("User identified, id given: %s", nextId);
      }
    }
  }
}
