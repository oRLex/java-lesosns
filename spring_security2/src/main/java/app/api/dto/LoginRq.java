package app.api.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Data
public class LoginRq {
  private Integer username;
  private String password;
  private boolean remember;
}
