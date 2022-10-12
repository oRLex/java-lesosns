package lesson15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ExApp1 {

  /**
   * f: String => int
   * f: String => int | Error
   * f: String => int | Exception
   * f: String => Integer
   * f: String => int | null
   *
   * 1. Optional<Int> = Stream<Int>
   * 2. custom class
   * 3. Exception
   */
  static Integer parseInt(String s) {
    return Integer.parseInt(s);
  }

  static Integer parseInt2a(String s) throws Exception {
    return parseInt3(s);
  }

  // checked
  static Integer parseInt3(String s) throws Exception {
    throw new Exception("");
  }

  // checked
  static void parseInt4(String s) {
    try {
      throw new Exception("");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  static void parseInt5(String s) {
    Objects.requireNonNull(s);
    Objects.requireNonNull(s, "message");
    Objects.requireNonNull(s, String.format("hard to build message %s, %s", null, null));

    Objects.requireNonNull(s, () -> String.format("hard to build message %s, %s", null, null));
    // ---------------------------
    Supplier<String> handler = new Supplier<String>() {
      @Override
      public String get() {
        return String.format("hard to build message %s, %s", null, null);
      }
    };
    Objects.requireNonNull(s, handler);
    // ---------------------------

    //    throw new RuntimeException();
//    throw new IllegalArgumentException();
//    throw new IllegalStateException(",kfnxdfnb");
    throw new IndexOutOfBoundsException();
  }

  static <A, B, C> C dododo1(A a, B b, BiFunction<A, B, C> f) {
    return f.apply(a, b);
  }

  static <A, B, C> C dododo2(A a, B b, Function<A, C> f) {
    return f.apply(a);
  }

  static <A, B> void doSomething(B b) {
    if (b == null) {
      throw new IllegalArgumentException(
          String.format(
          "ExApp1.doSomething(%s), b=null, shouldn't be", b)
      );
    }
  }

  public static void main1(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String line = sc.nextLine();
    int value = Integer.parseInt(line);

    try {
      FileReader fr = new FileReader(new File("1"));
      fr.read();
    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    }
  }

  public static void main(String[] args) {
    FileReader fr;
    try {
      fr = new FileReader(new File("1"));
    } catch (FileNotFoundException e) {
//       NEVER EVER DO THAT
    } finally {

    }
    // fr.read();

  }


}
