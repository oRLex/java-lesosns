package lesson14;

import java.io.*;
import java.util.Scanner;

public class TextIOApp2 {
  public static void mainBeforeJava7(String[] args) throws IOException {
    String s = "Hello World!";
    File file = new File("file.txt");
//    file.delete();
    FileWriter fw = new FileWriter(file);
    BufferedWriter bw = new BufferedWriter(fw, 16384);

    bw.write(s);

    bw.close();
  }

  static class MyIO implements AutoCloseable {

    @Override
    public void close() {

    }
  }

  public static void mainSinceJava7(String[] args) throws IOException {
    String s = "Hello World!";
    File file = new File("file.txt");

    try (MyIO io = new MyIO()) {

    }

    // try with resources, since Java 7
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(file), 16384)) {
      bw.write(s);
    }
  }

  public static void mainReadBefore7(String[] args) throws IOException {
    File file = new File("file.txt");
    FileReader fr = new FileReader(file);
    InputStream is = System.in;
//    BufferedInputStream bis = new BufferedInputStream(is);
//    InputStreamReader isr = new InputStreamReader(is);

//    BufferedReader br = new BufferedReader(isr);
    BufferedReader br = new BufferedReader(fr);
    String line;
    while (true) {
      line = br.readLine();
      if (line == null) break;
      System.out.println(line);
    }
    br.close();
  }

  // since java7
  public static void main(String[] args) throws IOException {
    File file = new File("file.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while (true) {
        line = br.readLine();
        if (line == null) break;
        System.out.println(line);
      }
    }
  }

}
