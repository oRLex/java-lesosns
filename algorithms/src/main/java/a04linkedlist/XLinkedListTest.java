package a04linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XLinkedListTest {

  @Test
  public void test0() {
    XLinkedList<Integer> ll = new XLinkedList<>();
    assertEquals(0, ll.len_it());
    ll.addHead(10);
    assertEquals(1, ll.len_it());
  }

  @Test
  public void test1() {
    XLinkedList<Integer> ll = new XLinkedList<>();
    assertEquals(0, ll.len_it());
    ll.addHead(10);
    assertEquals(1, ll.len_it());
    ll.addHead(15);
    ll.addHead(20);
    assertEquals(3, ll.len_it());
  }

  @Test
  public void test2() {
    XLinkedList<Integer> ll = new XLinkedList<>();
    assertFalse(ll.contains_it(55));
    ll.addHead(10);
    assertTrue(ll.contains_it(10));
  }

  @Test
  public void test3() {
    XLinkedList<Integer> ll = new XLinkedList<>();
    ll.addHead(1);
    ll.addHead(2);
    ll.addHead(3);
    assertEquals("3, 2, 1", ll.toString());
  }

  @Test
  public void test4() {
    XLinkedList<Integer> ll = new XLinkedList<>();
    ll.addTail(1);
    ll.addTail(2);
    assertEquals("1, 2", ll.toString());
  }
}
