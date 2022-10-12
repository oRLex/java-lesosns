package web3sql1;

import java.sql.*;
import java.util.ArrayList;

public class SQL1App {

  public static void main(String[] args) throws SQLException {
    try (
      Connection conn1 = DriverManager.getConnection(
      "jdbc:postgresql://localhost:5432/fs13",
      "postgres", "pg123456");

      Connection conn2 = DriverManager.getConnection(
      "jdbc:mysql://localhost:3306/db",
      "root", "root123");
    ) {
      PreparedStatement stmt = conn1.prepareStatement("select * from users");
      ResultSet result = stmt.executeQuery();
      ArrayList<Person> people = new ArrayList<>();
      while (result.next()) {
        Integer id = result.getObject("id", Integer.class);
        String name = result.getString("name");
        Integer group = result.getObject("group_id", Integer.class);
//        Integer group = result.get[Integer]("group_id"); // Scala
        Person p = new Person(id, name, group);
        people.add(p);
      }
      people.forEach(System.out::println);
    }

  }

}
