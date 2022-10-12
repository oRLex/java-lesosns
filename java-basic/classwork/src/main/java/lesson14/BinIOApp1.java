package lesson14;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class BinIOApp1 {
  public static void mainWrite(String[] args) throws IOException {
    File file = new File("file2.bin");
    FileOutputStream fos = new FileOutputStream(file);
    ObjectOutputStream oos = new ObjectOutputStream(fos);

    oos.write('A');
    oos.write(13);
    oos.write('B');
    List<Integer> ints = Arrays.asList(3, 5, 7, 9);
    oos.writeObject(ints); // serialization

    oos.close();
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    File file = new File("file2.bin");
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);

    int b1 = ois.read(); // 'A'
    int b2 = ois.read(); // 13
    int b3 = ois.read(); // 'B'
    List<Integer> ints = (List<Integer>) ois.readObject(); // deserialization
    System.out.println(ints);

    ois.close();
  }
}
