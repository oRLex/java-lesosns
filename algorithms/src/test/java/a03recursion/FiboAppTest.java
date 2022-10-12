package a03recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiboAppTest {

  private final FiboApp f = new FiboApp();

  void fibo1() {
    assertEquals(1, f.fibo(1));
  }

  @Test
  void fibo2() {
    assertEquals(1, f.fibo(2));
  }

  @Test
  void fibo3() {
    assertEquals(2, f.fibo(3));
  }

  @Test
  void fibo4() {
    assertEquals(3, f.fibo(4));
  }

  @Test
  void fibo5() {
    assertEquals(5, f.fibo(5));
  }

  @Test
  void fibo6() {
    assertEquals(8, f.fibo(6));
  }

  @Test
  void fibo10() {
    assertEquals(55, f.fibo(10));
  }

  @Test
  void fibo60() {
    assertEquals(1548008755920L, f.fibo(60));
  }

  @Test
  void fibo100() {
    assertEquals(3736710778780434371L, f.fibo(100));
  }
}