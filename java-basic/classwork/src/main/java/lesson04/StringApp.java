package lesson04;

import static lesson03.Task1FillAndSeparateEvenAndOdd.randomRange;

public class StringApp {
  public static void main(String[] args) {
    // String Pool
    String s = "Hello World";
    // Heap
    byte[] b = {0x12, 0x3e, 0x45, 0x67, (byte)0xe8, (byte)0x9b};
    String p0 = new String(new byte[] { 0b0011001, 0b00110010, 0b00110011 }); // 123
    String p1 = new String(new byte[] { 0x31, 0x32, 0x33 }); // 123
    String p2 = new String(new byte[] { 49, 50, 51 }); // 123
    int length = s.length();
    char ch = s.charAt(0);// 'H'
    char c2 = 'H'; // short
    char c3 = (char) (c2 + 1); // I
    int x = 'Z'- 'A'; // 25
    char aToZ = (char) (Math.random() * ('Z' - 'A' + 1) + 'A');
    char aToZ2 = (char) randomRange('A', 'Z');
    int z = 123456;
    short z2 = (short) z;
    System.out.println(z);
    System.out.println(z2);

    int  k1 = 33;  // char "!"
    int  k2 = 'Z'; // int 90
    char k3 = '7'; // int 55
    char k4 = 55;  // char '7'
  }
}
