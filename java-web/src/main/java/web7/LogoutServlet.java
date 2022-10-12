package web7;

import web6.CookieHelpers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {

    CookieHelpers.read(rq)
      .ifPresent(c -> {
        c.setMaxAge(0);
        rs.addCookie(c);
      });

    rs.sendRedirect("/menu");
  }

}
