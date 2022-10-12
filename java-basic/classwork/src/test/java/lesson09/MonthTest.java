package lesson09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthTest {

  @Test
  public void m01() {
    assertEquals(31, Month.count(1));
  }

  @Test
  public void m02() {
    assertEquals(28, Month.count(2));
  }

  @Test
  public void m03() {
    assertEquals(31, Month.count(3));
  }

  @Test
  public void m04() {
    assertEquals(30, Month.count(4));
  }

  @Test
  public void m05() {
    assertEquals(31, Month.count(5));
  }

  @Test
  public void m06() {
    assertEquals(30, Month.count(6));
  }

  @Test
  public void m07() {
    assertEquals(31, Month.count(7));
  }

  @Test
  public void m08() {
    assertEquals(31, Month.count(8));
  }

  @Test
  public void m09() {
    assertEquals(30, Month.count(9));
  }

  @Test
  public void m10() {
    assertEquals(31, Month.count(10));
  }

  @Test
  public void m11() {
    assertEquals(30, Month.count(11));
  }

  @Test
  public void m12() {
    assertEquals(31, Month.count(12));
  }

}
