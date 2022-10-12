package web7;

import web2.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.UUID;

/**
 * http://localhost:8080/upload
 */
public class UploadServlet extends HttpServlet {

  private final TemplateEngine te;

  public UploadServlet(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    te.render("upload.ftl", resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (PrintWriter w = resp.getWriter()) {
      Collection<Part> parts = req.getParts();
      for (Part p: parts) {
        String name = p.getSubmittedFileName();
        w.println(name);

        InputStream inputStream = p.getInputStream();
        String newName = UUID.randomUUID().toString();
        Path destination = Paths.get(newName);

        Files.copy(inputStream, destination);
      }
      w.println("Done!");
    }
  }

}
