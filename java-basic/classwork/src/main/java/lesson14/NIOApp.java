package lesson14;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NIOApp {
  public static void main(String[] args) throws IOException {
    new File("/a/b/c.txt");

    Path file = Paths.get("path1/", "/path2", "file");
    InputStream is = null;
    OutputStream os = null;
    Files.copy(file, file);
    Files.copy(is, file);
    Files.copy(file, os);

    Files.lines(file)
        .filter(s -> s.startsWith("A"))
        .map(s -> s.toUpperCase())
        .flatMap(s -> Arrays.stream(s.split(" ")))
        .collect(Collectors.toList());

  }
}
