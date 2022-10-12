package a07tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

  @Test
  public void test1() {
    Tree t = new Tree();
    t.add(5);
    t.add(3);
    t.add(10);
    t.add(20);
    assertTrue(t.contains(3));
    assertFalse(t.contains(11));
    assertEquals(4, t.size());
    assertEquals(4, t.size2());
  }

}
