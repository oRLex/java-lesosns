package a07tree;

public class Trie {

  static class Node {
    char letter;
    Node[] next;

    public Node(char letter) {
      this.letter = letter;
      this.next = new Node[26];
    }

    int indexToGo(char nextLetter) {
      return nextLetter - 'a';
    }
  }
}
