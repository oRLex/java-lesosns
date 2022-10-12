package a04linkedlist;

import java.util.Optional;
import java.util.StringJoiner;

public class XLinkedList<A> {

  class Node {
    final A value;
    Node next;

    Node(A value) {
      this.value = value;
    }
  }

  private Node head;

  public void addHead(A a) {
    Node node = new Node(a);
    node.next = head;
    head = node;
  }

  public Node addTailR(A a, Node node) {
    if (node == null) return new Node(a);
    node.next = addTailR(a, node.next);
    return node;
  }

  public void addTail(A a) {
    head = addTailR(a, head);
  }

  public boolean contains_it(A a) {
    Node curr = head;
    while (curr != null) {
      if (curr.value.equals(a)) return true;
      curr = curr.next;
    }
    return false;
  }

  public boolean contains_r0(A a, Node curr) {
    if (curr == null) return false;
    if (curr.value.equals(a)) return true;
    return contains_r0(a, curr.next);
  }

  // tail recursive
  public boolean contains_r(A a) {
    return contains_r0(a, head);
  }

  public int len_it() {
    int len = 0;
    Node curr = head;
    while (curr != null) {
      len++;
      curr = curr.next;
    }
    return len;
  }

  public int len_r0(Node curr) {
    if (curr == null) return 0;
    int tail_len = len_r0(curr.next);
    return 1 + tail_len;
  }

  public int len_r() {
    return len_r0(head);
  }

  public int len_tr0(int len, Node curr) {
    if (curr == null) return len;
    return len_tr0(len + 1, curr.next);
  }

  public int len_tr() {
    return len_tr0(0, head);
  }

  /** NULL will be returned in case of index out of range */
  public A get_it1(int idx) {
    try {
      return get_it(idx);
    } catch (IndexOutOfBoundsException x) {
      return null;
    }
  }

  /* will not be shown */
  public Optional<A> get_it3(int idx) {
    return Optional.ofNullable(get_it(idx));
  }

  public A get_it(int idx) throws IndexOutOfBoundsException {
    int curr_idx = 0;
    Node curr = head;
    while (curr != null) {
      if (curr_idx == idx) return curr.value;
      curr_idx++;
      curr = curr.next;
    }
    throw new IndexOutOfBoundsException(
      String.format("index %d is out of range %d", idx, curr_idx)
    );
  }

  // null if out of bounds
  public A get_r0(int idx, Node node) {
    if (node == null) return null;
    if (idx == 0) return node.value;
    return get_r0(idx - 1, node.next);
  }

  // tail recursive
  // null if out of bounds
  public A get_r(int idx) {
    return get_r0(idx, head);
  }

  public String toStringR(Node node, StringJoiner sj) {
    if (node == null) return sj.toString();
    sj.add(node.value.toString());
    return toStringR(node.next, sj);
  }

  @Override
  public String toString() {
    return toStringR(head, new StringJoiner(", "));
  }

  public void toStringR2(Node node, StringJoiner sj) {
    if (node == null) return;
    sj.add(node.value.toString());
    toStringR2(node.next, sj);
  }

  public String toString2() {
    StringJoiner sj = new StringJoiner(", ");
    toStringR2(head, sj);
    return sj.toString();
  }
}
