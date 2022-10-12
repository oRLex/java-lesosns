package web3sql1;

import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLApp3 {

  public static void main(String[] args) {

  }
  public static void doSomething(Connection conn) throws SQLException {
    conn.setAutoCommit(false);
    try {
      PreparedStatement st1 = conn.prepareStatement("update...");
      st1.execute();
      conn.prepareStatement("update...");
      conn.prepareStatement("update...");
//    ...
//    ...
//    ...
      conn.commit();
    } catch (Exception x) {
      conn.rollback();
    }

  }

}
