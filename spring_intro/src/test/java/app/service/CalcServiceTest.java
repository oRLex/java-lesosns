package app.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalcServiceTest {

  @Autowired
  private CalcService calcService;

  @Test
  void add() {
    int expected = 2;
    int real = calcService.add(1, 1);
    assertEquals(real, expected);
  }
}