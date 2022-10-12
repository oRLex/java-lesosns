package web2;

public class Person {
  final int p_id;
  final String p_name;

  public Person(int id, String name) {
    this.p_id = id;
    this.p_name = name;
  }

  public int getId() {
    return p_id;
  }

  public String getName() {
    return p_name;
  }

  public String getNameUpper() {
    return p_name.toUpperCase();
  }
}
