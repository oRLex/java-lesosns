package web3sql1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQL2App {

  public static void main(String[] args) throws SQLException {
    try (
      Connection conn1 = DriverManager.getConnection(
      "jdbc:postgresql://localhost:5432/fs13",
      "postgres", "pg123456");
    ) {
      PreparedStatement stmt = conn1.prepareStatement("insert into users (name, group_id) values (?, ?)");
      stmt.setString(1, "Jackson");
      stmt.setInt(2, 33);
      stmt.execute();
    }

  }

}
