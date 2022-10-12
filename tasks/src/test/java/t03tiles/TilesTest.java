package t03tiles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TilesTest {

  private final Tiles t = new Tiles();

  @Test
  void count1() {
    assertEquals(1, t.comb(1));
  }

  @Test
  void count2() {
    assertEquals(2, t.comb(2));
  }

  @Test
  void count3() {
    assertEquals(3, t.comb(3));
  }

  @Test
  void count4() {
    assertEquals(5, t.comb(4));
  }

  @Test
  void count9() {
    assertEquals(55, t.comb(9));
  }
}
