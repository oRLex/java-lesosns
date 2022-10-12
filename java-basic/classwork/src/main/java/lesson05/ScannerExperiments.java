package lesson05;

import java.util.Optional;
import java.util.Scanner;

public class ScannerExperiments {

  public static Optional<Integer> toInt2(String s) {
    try {
      int value = toInt(s);
      return Optional.of(value);
    } catch (NumberFormatException x) {
      return Optional.empty();
    }
  }

  public static boolean isInt(String s) {
    try {
      int value = toInt(s);
      return true;
    } catch (NumberFormatException x) {
      return false;
    }
  }

  public static int toInt(String s) {
    return Integer.parseInt(s);
  }

  public static int expectInt(Scanner scanner) {
    do {
      String input = expectString(scanner);
      if (isInt(input)) return toInt(input);
      System.out.printf("You have entered `%s`, number expected, please try again", input);
    } while (true);
  }

  public static String expectString(Scanner scanner) {
    return scanner.next();
  }

  public static void main1(String[] args) {
    Scanner sc = new Scanner(System.in);

    String name = expectString(sc);
    int row = expectInt(sc);
    int col = expectInt(sc);

  }

  public static void main2(String[] args) {
    Optional<Integer> i1 = toInt2("123");         // Optional.of(123)
    Optional<Integer> i2 = toInt2("abracadabra"); // Optional.empty
    System.out.println(i1);
    System.out.println(i2);
    System.out.println(i1.isPresent()); // true
    System.out.println(i2.isPresent()); // false
    int x1 = i1.get(); // 123
//    int x2 = i2.get(); // Exception
    i1.ifPresent((Integer x) -> System.out.println(x)); // 123
    i2.ifPresent(x -> System.out.println(x)); //
  }

  public static void main3(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Optional<Integer> value = toInt2(scanner.next());
    String result = value.map(x -> x * 2)
        .map(x -> String.format("Result is %d", x))
        .orElse("Non Integer given");
    System.out.println(result);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Optional<Integer> ox = toInt2(sc.next());
    Optional<Integer> oy = toInt2(sc.next());
    Optional<Optional<Integer>> result1 = ox.map(x -> oy.map(y -> x + y));
    Optional         <Integer>  result2 = ox.flatMap(x -> oy.map(y -> x + y));
    Optional<Integer> r3 = ox.flatMap(x -> oy.map(y -> x + y));
    Optional<String>  r4 = r3.map(x -> String.valueOf(x));
//        .map(String::valueOf)
//        r3.orElse(-1);
    String result = r4.orElse("one of given isn't integer");
    System.out.println(result);
  }
}
