package t04cuntries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountriesTest {

  private final Countries c = new Countries();

  public static int[][] data() {
    int[][] a = new int[7][3];
    a[0][0] = 5;
    a[1][0] = 4;
    a[2][0] = 3;
    a[3][0] = 2;
    a[4][0] = 3;
    a[5][0] = 1;
    a[6][0] = 4;

    a[0][1] = 4;
    a[1][1] = 3;
    a[2][1] = 2;
    a[3][1] = 2;
    a[4][1] = 3;
    a[5][1] = 4;
    a[6][1] = 1;

    a[0][2] = 4;
    a[1][2] = 4;
    a[2][2] = 4;
    a[3][2] = 2;
    a[4][2] = 4;
    a[5][2] = 4;
    a[6][2] = 1;
    return a;
  }

  @Test
  void count() {
    int real = c.count(data());
    int expected = 11;
    assertEquals(expected, real);
  }
}