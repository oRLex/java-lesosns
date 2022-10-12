package app.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@AllArgsConstructor
public class DbUsersInitial {

  private final DbUserRepo dbUserRepo;
  private final PasswordEncoder enc;

  public void create() {
    dbUserRepo.saveAll(Arrays.asList(
       new DbUser("jim",  enc.encode("123"), "USER"),
       new DbUser("john", enc.encode("234"), "ADMIN"),
       new DbUser("jack", enc.encode("345"), "ADMIN", "USER"),
       new DbUser("joe",  enc.encode("456"))
    ));
  }
}
