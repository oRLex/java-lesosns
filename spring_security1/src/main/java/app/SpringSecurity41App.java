package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * authentication: (username, password) => Optional[Id]
 * authentication: (token) => Optional[Id]
 * authentication: (whatever) => Optional[Id]
 *
 * authorization: (id, operation) => boolean
 * id -< role
 * resource -< role
 *
 * f: (username, password) => boolean
 * authentication + authorization
 *
 * auth(user, pass)
 *   .map(id => authorize(id, operation))
 *   .orElse(false)
 *
 * http://localhost:8080/       - default behavior (auth only)
 *
 * http://localhost:8080/guest  - any
 * http://localhost:8080/home   - any authenticated (with any ROLE)
 * http://localhost:8080/admin  - authorized with ADMIN role
 * http://localhost:8080/me     - authorized with USER role
 * http://localhost:8080/news   - authorized with any USER or ADMIN role
 *
 * http://localhost:8080/login  - login link added by spring security
 * http://localhost:8080/logout - logout link added by spring security
 *
 * http://localhost:8080/h2-console - H2 web console
 *
 * http://localhost:8080/api/login    - POST: authentication
 * http://localhost:8080/api/logout   - POST: invalidation
 * http://localhost:8080/api/register - POST: registration
 *
 * http://localhost:8080/api/guest  - GET - any unregistered
 * http://localhost:8080/api/home   - GET - any authenticated
 * http://localhost:8080/api/admin  - GET - authorized with ADMIN role
 * http://localhost:8080/api/me     - GET - authorized with USER role
 * http://localhost:8080/api/news   - GET - authorized with any USER or ADMIN role
 *
 * spring.datasource.url = jdbc:h2:mem:testdb
 * spring.datasource.username = sa
 * spring.datasource.password = sa
 *
 * user   password   roles
 * ----- ---------- ------------
 * jim      123      USER
 * john     234      ADMIN
 * jack     345      ADMIN, USER
 * joe      456      - no roles
 * -----------------------------
 */
@SpringBootApplication
public class SpringSecurity41App {
  public static void main(String[] args) {
    SpringApplication.run(SpringSecurity41App.class, args);
  }
}
