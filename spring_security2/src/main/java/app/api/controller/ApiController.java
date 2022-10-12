package app.api.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

  @GetMapping("/home")
  public String handle_home(Authentication a) {

    Object principal = a.getPrincipal();
    UserDetails userDetails = (UserDetails) principal;

    return
      String.format(
        "user id from token is %s",
        userDetails.getUsername()
      );
  }
}
