package lesson09;

public class LC {
  final char ch;
  final int count;

  LC(char ch, int count) {
    this.ch = ch;
    this.count = count;
  }

  @Override
  public String toString() {
    return String.format("%c : %d", ch, count);
  }
}
