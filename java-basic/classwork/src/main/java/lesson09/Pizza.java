package lesson09;

public class Pizza {

  static String[] names = {"Margarita", "QuattroFormaggi"};

  /**
   * 30/40/50/60
   * 3..6 * 10
   * ([0..3] + 3)* 10
   * (random * 4 + 3)* 10
   */
  static int randomSize() {
    return ((int)((Math.random() * 4)) + 3) * 10;
  }

  static String randomName() {
    int index = (int) (Math.random() * names.length);
    return names[index];
  }

  final int size;
  final String name;

  public Pizza(int size, String name) {
    this.size = size;
    this.name = name;
  }

  public static Pizza random() {
    return new Pizza(randomSize(), randomName());
  }

  @Override
  public String toString() {
    return String.format("%s : %d", name, size);
  }
}
