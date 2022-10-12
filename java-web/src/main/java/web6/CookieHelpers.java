package web6;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

public class CookieHelpers {

  public static final String cookieName = "UID";

  private static boolean validate(Cookie c) {
    return true;
  }

  public static Optional<Cookie> read(HttpServletRequest rq, String name) {
    return Optional.ofNullable(rq.getCookies())
      .flatMap(x ->
        Arrays.stream(x).filter(c -> c.getName().equals(name)).findAny()
      )
      .filter(CookieHelpers::validate);
  }

  public static Optional<Cookie> read(HttpServletRequest rq) {
    return read(rq, cookieName);
  }

}
