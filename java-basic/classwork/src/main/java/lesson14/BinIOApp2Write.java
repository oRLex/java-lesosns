package lesson14;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class BinIOApp2Write {

  public static void main(String[] args) throws IOException {
    File file = new File("file3.bin");
    FileOutputStream fos = new FileOutputStream(file);
    try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      Student jim = new Student(33, "Jim");
      oos.writeObject(jim);
    }
  }

  public static void main2(String[] args) throws IOException {
    File file = new File("file3.bin");
    FileOutputStream fos = new FileOutputStream(file);
    try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      List<Student> students = Arrays.asList(new Student(33, "Jim"));

      for (Student s: students) {
        oos.writeObject(s);
      }

      students.forEach(s -> {
        try {
          oos.writeObject(s);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    }
  }

}
