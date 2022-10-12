package web2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
    String fileName = "web_content/hello.html";
    try (OutputStream os = rs.getOutputStream()) {
      Path filePath = Paths.get(fileName);
      Files.copy(filePath, os);
    }
  }
}
