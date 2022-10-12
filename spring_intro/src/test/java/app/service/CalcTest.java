package app.service;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

  @org.junit.jupiter.api.Test
  void add() {
    int expected = 2;
    int real = new Calc().add(1, 1);
    assertEquals(real, expected);
  }

}