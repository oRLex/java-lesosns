package web7;

import web6.CookieHelpers;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter2 implements HttpFilter {

  private boolean validate2(Cookie c) {
    return true;
  }

  @Override
  public void doHttpFilter(HttpServletRequest rq, HttpServletResponse rs, FilterChain chain) throws ServletException, IOException {
    if (CookieHelpers.read(rq).filter(c -> validate2(c)).isPresent()) {
      chain.doFilter(rq, rs);
    } else {
      rs.setStatus(401);
//        rs.sendRedirect("/login");
    }
  }

}
