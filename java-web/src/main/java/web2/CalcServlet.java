package web2;

import web1.Calculator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalcServlet extends HttpServlet {

  private final TemplateEngine te = TemplateEngine.folder("web_content");

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String fileName = "web_content/calc.html";
    try (OutputStream os = rs.getOutputStream()) {
      Path filePath = Paths.get(fileName);
      Files.copy(filePath, os);
    }
  }

  @Override
  protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String res = Calculator.doCalc(
      rq.getParameter("x"),
      rq.getParameter("y"),
      rq.getParameter("op")
    );

    Map<String, Object> data = new HashMap<>();

    data.put("result", res);
    data.put("p", new Person(33, "Jim"));

    ArrayList<Person> people = new ArrayList<>();
    people.add(new Person(1, "Sergio"));
    people.add(new Person(2, "Jack"));
    people.add(new Person(3, "Nate"));
    data.put("people", people);

    te.render("calc_res.ftl", data, rs);
  }
}
