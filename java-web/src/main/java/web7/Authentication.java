package web7;

import java.util.HashMap;
import java.util.Map;

public class Authentication {

  private final Map<String, String> users = new HashMap<String, String>() {{
    put("jim", "123");
    put("john", "456");
  }};

  public boolean check(String name, String password) {
    return users.containsKey(name) && users.get(name).equals(password);
  }

}
