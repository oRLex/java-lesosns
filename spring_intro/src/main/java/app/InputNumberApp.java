package app;

import java.util.Scanner;

public class InputNumberApp {

  static int expectInt(Scanner scanner) {
    String next = scanner.next();
    try {
      return Integer.parseInt(next);
    } catch (Exception ex) {
      System.out.println("non number enter. again");
      return expectInt(scanner);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int x = expectInt(scanner);
  }
}
