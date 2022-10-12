package web8;

import org.eclipse.jetty.server.Server;

public class Application {

  public static void main(String[] args) throws Exception {
    // ...

    // N
    new DbSchema(
      DbProp.conn,
      DbProp.user,
      DbProp.pass
    ).migrate();

    // ...

    // M. M > N
    Server server = new Server(8080);
    server.start();
    server.join();
  }

}
