package web7;

import web6.CookieHelpers;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  private boolean isHttp(ServletRequest rq, ServletResponse rs) {
    return rq instanceof HttpServletRequest
      && rs instanceof HttpServletResponse;
  }

  private boolean validate2(Cookie c) {
    return true;
  }

  @Override
  public void doFilter(ServletRequest rq0, ServletResponse rs0, FilterChain chain) throws IOException, ServletException {
    if (isHttp(rq0, rs0)) {
      HttpServletRequest rq = (HttpServletRequest) rq0;
      HttpServletResponse rs = (HttpServletResponse) rs0;
      // ==============================
      if (CookieHelpers.read(rq).filter(c -> validate2(c)).isPresent()) {
        // happy path
        chain.doFilter(rq0, rs0);
      } else {
        // wrong way
        // send redirect
        rs.setStatus(401);
//        rs.sendRedirect("/login");
      }
      // ==============================
    } else {
      chain.doFilter(rq0, rs0);
    }
  }

  @Override
  public void destroy() {

  }

}
