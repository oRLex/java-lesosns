package web1;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalcServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
    try (PrintWriter w = rs.getWriter()) {
      String outcome = Calculator.doCalc(
        rq.getParameter("x"),
        rq.getParameter("y"),
        rq.getParameter("op")
      );
      w.println(outcome);
    }
  }
}
