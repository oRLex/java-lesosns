package lesson14;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TextIOApp1 {
  public static void main(String[] args) {
    InputStream in = System.in; // read one byte
    Scanner scanner = new Scanner(System.in);

//    System.out.println();
    PrintStream out = System.out; // write one byte
    out.println("ABC");
  }
}
