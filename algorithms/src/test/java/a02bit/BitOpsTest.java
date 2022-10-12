package a02bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BitOpsTest {

  private final BitOps bit = new BitOps();

  @Test
  void intToBin1() {
    int x = 1;
    assertEquals(Integer.toBinaryString(x), bit.intToBin(x));
  }

  @Test
  void intToBin2() {
    int x = 2;
    assertEquals(Integer.toBinaryString(x), bit.intToBin(x));
  }

  @Test
  void intToBin3() {
    int x = 10;
    assertEquals(Integer.toBinaryString(x), bit.intToBin(x));
  }

  @Test
  void intToBin4() {
    int x = 117;
    assertEquals(Integer.toBinaryString(x), bit.intToBin(x));
  }

  @Test
  void intToBin5() {
    int expected = 117;
    int actual = bit.binToDec("1110101");
    assertEquals(expected, actual);
  }
}