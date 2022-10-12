package app.api.controller;

import app.api.dto.LoginRq;
import app.api.dto.LoginRs;
import app.security.UserService;
import app.security.jwt.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

  private final UserService userService;
  private final JwtService jwt;

  @PostMapping("/login")
  public LoginRs handle_login(@RequestBody LoginRq rq) {
    log.info(rq);
    return userService
      .login(rq.getUsername(), rq.getPassword())
      .map(id -> jwt.encode(id, rq.isRemember()))
      .map(t -> LoginRs.valid(t))
      .orElse(LoginRs.invalid());
  }

}
