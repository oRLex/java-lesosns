package lesson09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateBracketsTest {

  private ValidateBrackets val = new ValidateBrackets();

  @Test
  void validate1() {
    assertTrue(val.validate(""));
  }

  @Test
  void validate2() {
    assertTrue(val.validate("(())"));
  }

  @Test
  void validate3() {
    assertTrue(val.validate("(()())"));
  }

  @Test
  void validate4() {
    assertTrue(val.validate("(()())()"));
  }

  @Test
  void validate5() {
    assertFalse(val.validate("("));
  }

  @Test
  void validate6() {
    assertFalse(val.validate("(()"));
  }

  @Test
  void validate7() {
    assertFalse(val.validate("())"));
  }

  @Test
  void validate8() {
    assertFalse(val.validate("()(()(())))"));
  }
}
