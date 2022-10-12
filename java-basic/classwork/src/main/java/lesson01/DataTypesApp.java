package lesson01;

public class DataTypesApp {
  public static void main(String[] args) {
    // 8 bytes
    long l1 = 7;
    long l2 = 2_000000000_000000000L;
    // 4 bytes
    int x = 2_000_000_000; // -2**31 ..0.. 2**31 -1
    // 2 bytes
    short sh1 = 32_000; // -32768 .. 32767
    // 1 byte
    byte b = 127; // -128 .. 127
    byte b3 = 0b00000001;
    byte b4 = (byte) 255;

    // 4 bytes
    float f1 = 3.5F;
    // 8 bytes
    double d1 = 3.14;

    // boolean
    boolean b1 = true;
    boolean b2 = false;

    // char - 2 bytes, UTF-16
    char c = 'A'; // short: 0..127
    char d = 'я'; // short: 1000....+

    System.out.println("Alex".length());
    System.out.println("алекс".length());
    System.out.println("алекс".getBytes().length);

    String s2 = new String("Jim");
    String s1 = "Jim";
    String s3 = "Jim";
    String s1u = s1.toUpperCase();
//    String s5 = s1 + "A";
  }
}
