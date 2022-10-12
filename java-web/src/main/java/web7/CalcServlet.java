package web7;

import web2.TemplateEngine;
import web6.CookieHelpers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

public class CalcServlet extends HttpServlet {

  private final TemplateEngine te;
  private final Calculator calc;

  public CalcServlet(TemplateEngine te, Calculator calc) {
    this.te = te;
    this.calc = calc;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse rs) throws ServletException, IOException {
    if (!CookieHelpers.read(req).isPresent()) {
      rs.sendRedirect("/login");
    }

    HashMap<String, Object> data = new HashMap<>();
    data.put("message", "");
    te.render("calc.ftl", data, rs);
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    Optional<String> ox = Optional.ofNullable(rq.getParameter("x"));
    Optional<String> oy = Optional.ofNullable(rq.getParameter("y"));
    Optional<String> oop = Optional.ofNullable(rq.getParameter("op"));

    String result = ox.flatMap(x ->
      oy.flatMap(y ->
        oop.map(op ->
          calc.doCalc(x, y, op)
        )))
      .orElse("wrong params given");

    HashMap<String, Object> data = new HashMap<>();
    data.put("message", result);
    te.render("calc.ftl", data, rs);
  }
}
