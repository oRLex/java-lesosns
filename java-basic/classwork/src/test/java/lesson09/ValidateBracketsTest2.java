package lesson09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidateBracketsTest2 {

  private ValidateBrackets2 val = new ValidateBrackets2();

  @Test
  void validate1() {
    assertTrue(val.validate(""));
  }

  @Test
  void validate2() {
    assertTrue(val.validate("(())"));
  }

  @Test
  void validate21() {
    assertTrue(val.validate("([])"));
  }

  @Test
  void validate22() {
    assertTrue(val.validate("([]){}"));
  }

  @Test
  void validate23() {
    assertTrue(val.validate("([]){<>}"));
  }

  @Test
  void validate24() {
    assertTrue(val.validate("[([]){<>}]"));
  }

  @Test
  void validate25() {
    assertFalse(val.validate("([)]"));
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

  @Test
  void validate81() {
    assertFalse(val.validate("[()(()(())))"));
  }

  @Test
  void validate82() {
    assertFalse(val.validate("[()(()(())))]>"));
  }
}
