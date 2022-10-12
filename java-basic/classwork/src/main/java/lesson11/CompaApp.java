package lesson11;

public class CompaApp {

  static class Pizza implements Comparable<Pizza> {
    final String name;
    final int size;

    Pizza(String name, int size) {
      this.name = name;
      this.size = size;
    }

    @Override
    public int compareTo(Pizza that) {
//      return this.size - that.size; // by size
//      return this.name.length() - that.name.length(); // by name length
//      return this.name.compareTo(that.name); // by alphabet, asc
      return -this.name.compareTo(that.name); // by alphabet, desc
    }
  }

  public static void main(String[] args) {
    int x = 3;
    int y = 5;
    if (x < y) {}

    Pizza p1 = new Pizza("Margarita", 30);
    Pizza p2 = new Pizza("QuattroFormagi", 10);

    if (p1.compareTo(p2) > 1) {}// p1 > p2


  }
}
