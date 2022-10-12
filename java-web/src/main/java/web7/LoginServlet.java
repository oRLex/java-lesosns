package web7;

import web2.TemplateEngine;
import web6.CookieHelpers;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class LoginServlet extends HttpServlet {

  private final TemplateEngine te;
  private final Authentication auth;

  public LoginServlet(TemplateEngine te, Authentication auth) {
    this.te = te;
    this.auth = auth;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();
    data.put("message", "");
    te.render("login.ftl", data, rs);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
    Optional<String> oname = Optional.ofNullable(req.getParameter("username"));

    Boolean success = oname
      .flatMap(name ->
        Optional.ofNullable(req.getParameter("password"))
          .map(pass -> auth.check(name, pass)
        ))
      .orElse(false);

    if (success) {
      // set cookie
      Cookie c = new Cookie(CookieHelpers.cookieName, oname.get());
//      c.setMaxAge(rememberMe ? timeRemember : timeNormal);
      c.setPath("/");
      rs.addCookie(c);

      // redirect
      rs.sendRedirect("/calc");
    } else {
      HashMap<String, Object> data = new HashMap<>();
      data.put("message", "wrong user/password combination given");
      te.render("login.ftl", data, rs);
    }
  }
}
