package a02bit;

import java.util.stream.Stream;

public class BitOps {

  /**
   *   a  b  a&b  a|b  !a  a^b
   * --------------------------
   *   0  0   0    0    1   0
   *   0  1   0    1    1   1
   *   1  0   0    1    0   1
   *   1  1   1    1    0   0
   *
   *  5   00000101
   *  7   00000111
   * 5&7  00000101
   *
   *  b5   -------1
   *  a    00000001
   *       --------
   * 5&1   00000001
   *
   *  b    -------0
   *  a    00000001
   *       --------
   * 5&1   00000000
   *
   *   117-64=53-32=21-16=5-4=1
   *   01110101
   *   00000000
   *          1 - 1
   *         1  - 2
   *        1   - 4
   *       1    - 8
   *      1     - 16
   *     1      - 32
   *    1       - 64
   *   1        - 128
   * ---------------------------
   *          0
   *          1    2^1
   *         --
   *         00
   *         01
   *         10
   *         11    2^2
   *        ---
   *        000
   *        001
   *        010
   *        011
   *        100
   *        101
   *        110
   *        111    2^3
   *
   *   10000  -  16
   *    1000  -  8
   *    0100  -  4
   *
   *    1010  - 10
   *    0101  - 5
   *    0010  - 2
   *
   *    y = x * 2
   *    y = x << 1
   *
   *    y = x * 4
   *    y = x << 2
   *
   *    y = x / 2
   *    y = x >> 1
   *
   *    y = x * 10
   *    y = x << 3 + x << 1
   *
   */

  String intToBinV0(int x) {
    StringBuilder sb = new StringBuilder();
    while (x > 0) {
      sb.append(x % 2);
      x /= 2;
    }
    return sb.reverse().toString();
  }

  String intToBinV1(int x) {
    StringBuilder sb = new StringBuilder();
    while (x > 0) {
      sb.append(x & 1);
      x = x >> 1; // x >>= 1;
    }
    return sb.reverse().toString();
  }

  /**
   * 0..255
   *
   * 01110101 = 117
   * 00111010 = 58
   * 00011101 = 29
   * 00001110 = 14
   *
   */
  String intToBinV2(int x) {
    StringBuilder sb = new StringBuilder();
//    int d0 = (x >> 0) % 2; // 1
//    int d1 = (x >> 1) % 2; // 0
//    int d2 = (x >> 2) % 2; // 1
//    int d3 = (x >> 3) % 2; // 0
//
    for (int i = 0; i < 7; i++) {
      int d = (x >> i) % 2;
      sb.append(d);
    }
    return sb.reverse().toString();
  }

  /**
   * 00000000 - 0
   * 00000001 - 1
   * 01111111 - 127
   * 10000000 - -128
   */
  String intToBinV3(int x) {
    StringBuilder sb = new StringBuilder();
    for (int i = 6; i >= 0; i--) {
      int d = (x >> i) & 0b00000000_00000000_00000000_00000001;
      sb.append(d);
    }
    return sb.toString();
  }

  String intToBin(int x) {
    byte[] bytes = new byte[7];
    for (int i = 6; i >= 0; i--) {
      byte d = (byte) ((x >> i) & 0b00000001);
      bytes[6 - i] = (byte) (d + '0'); // + 0x30 // + 48
    }
    return new String(bytes);
  }

  /**
   * "1110101" => 117
   */
  int binToDec(String bin) {
    int len = bin.length();
    int r = 0;
    for (int i = len - 1; i >= 0; i--) {
      char c = bin.charAt(i); // '0' / '1'
      int d = c - '0';        //  0  /  1
      r += d << (len - i - 1);
    }
    return r;
  }

  public static void main(String[] args) {
    System.out.println(Math.abs(Integer.MIN_VALUE));
  }

}
