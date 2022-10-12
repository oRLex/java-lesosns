package lesson04;

import java.util.Optional;

public class IntToStringApp {

  public static String intToString(int value) {
    StringBuilder sb = new StringBuilder();
    while (value > 0) {
      int lastDigit = value % 10; // 0..9
      char lastChar = (char) (lastDigit + '0'); // '0'..'9'
      sb.append(lastChar);
      value = value / 10;
    }
    return sb.reverse().toString();
  }

  public static int stringToInt1(String str) {
    int part = 0;

    for (int i = 0; i < str.length(); i++) {
      char symbol = str.charAt(i); // '9', '4', '5' // '3' (51)
      if (symbol < '0' || symbol > '9') throw new IllegalArgumentException(String.format("not digit given %s", str));
      int digitValue = symbol - '0'; // 51-48 = 3
      part = part * 10 + digitValue;
    }

    return part;
  }

  public static boolean isValidChar(char c) {
    return c >= '0' && c <= '9';
  }

  public static Optional<Integer> stringToInt1Opt(String str) {
    int part = 0;

    for (int i = 0; i < str.length(); i++) {
      char symbol = str.charAt(i); // '9', '4', '5' // '3' (51)
      if (!isValidChar(symbol)) return Optional.empty();
      int digitValue = symbol - '0'; // 51-48 = 3
      part = part * 10 + digitValue;
    }

    return Optional.of(part);
  }

  // ASCII, UTF-8 (english, first 128, only for one byte chars)
  public static int stringToInt(String str) {
    int part = 0;
    byte[] bytes = str.getBytes();
    for (byte digit: bytes) {
      int val = digit - '0'; // 51-48 = 3
      part = part * 10 + val;
    }
    return part;
  }

  public static void main1(String[] args) {
    String x = intToString(123); // "123"
    System.out.println(x);
  }

  public static void main(String[] args) {
    System.out.println(stringToInt1Opt("945")); // 1234
    System.out.println(stringToInt1Opt("945A")); // 1234
  }

}
