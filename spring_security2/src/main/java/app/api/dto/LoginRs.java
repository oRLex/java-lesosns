package app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginRs {
  private Integer code;
  private String message;
  private String token;

  public static LoginRs valid(String token) {
    return new LoginRs(0, "", token);
  }

  public static LoginRs invalid() {
    return new LoginRs(1, "wrong user/password pair", "");
  }
}
