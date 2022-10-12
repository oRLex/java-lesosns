package lesson14;

import java.io.*;

public class BinIOApp2Read {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    File file = new File("file3.bin");
    FileInputStream fis = new FileInputStream(file);
    try (ObjectInputStream ois = new ObjectInputStream(fis)) {
      Student student = (Student) ois.readObject();
      System.out.println(student);
    }
  }

}
