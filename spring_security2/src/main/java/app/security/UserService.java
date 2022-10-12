package app.security;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

  private final Map<Integer, String> users = new HashMap<Integer, String>() {{
    put(100, "123");
  }};

  public Optional<Integer> login(Integer id, String password) {
    return users.containsKey(id) && users.get(id).equals(password) ?
      Optional.of(id) : Optional.empty();
  }

}
