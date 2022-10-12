package web1;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
    rs.setHeader("TOKEN","123234");
    rs.addCookie(new Cookie("123", "qwe"));
    try (PrintWriter w = rs.getWriter()) {
      w.println("Hello, World!");
    }
//    rs.setStatus(500);
//    rs.sendRedirect("/new/location");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
