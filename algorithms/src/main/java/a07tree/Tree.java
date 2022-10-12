package a07tree;

import static util.Util.NI;

public class Tree {

  private Node root;

  static class Node {
    int value;
    Node right;
    Node left;
    int n = 1;

    private Node(int value) {
      this.value = value;
    }

    static Node of(int value) {
      return new Node(value);
    }
  }

  public void add_it(int value) {
    Node newNode = Node.of(value);
    if (root == null) {
      root = newNode;
      return;
    }
    Node curr = root;
    while (true) {
      if      (value > curr.value) {
        curr.n++;
        if (curr.right == null) {
          curr.right = newNode;
          return;
        } else {
          curr = curr.right;
        }
      }
      else if (value < curr.value) {
        curr.n++;
        if (curr.left == null) {
          curr.left = newNode;
          return;
        } else {
          curr = curr.left;
        }
      }
      else return; // already exists
    }

  }

  private int sizeR(Node curr) {
    return curr.right == null ? 0 : curr.right.n;
  }

  private int sizeL(Node curr) {
    return curr.left == null ? 0 : curr.left.n;
  }

  public Node addr(int value, Node curr) {
    if (curr == null) return Node.of(value);
    if      (value < curr.value) curr.left  = addr(value, curr.left);
    else if (value > curr.value) curr.right = addr(value, curr.right);
    else;
    //
    curr.n = 1 + sizeL(curr) + sizeR(curr);
    return curr;
  }

  public void add(int value) {
    root = addr(value, root);
  }

  /**
   * here we need to update
   * "n" after each add()
   */
  public int size2() {
    return root == null ? 0 : root.n;
  }

  public int size(Node curr) {
    if (curr == null) return 0;
    return 1 + size(curr.left) + size(curr.right);
  }

  public int size() {
    return size(root);
  }

  public boolean contains(int value) {
    Node curr = root;
    while (curr != null) {
      if      (value > curr.value) curr = curr.right;
      else if (value < curr.value) curr = curr.left;
      else /*if (curr.value == value)*/ return true;
    }
    return false;
  }

  private boolean containsr(int value, Node curr) {
    if (curr == null) return false;
    if (value > curr.value) return containsr(value, curr.right);
    if (value < curr.value) return containsr(value, curr.left);
    return true;
  }

  public boolean containsr(int value) {
    return containsr(value, root);
  }

}
