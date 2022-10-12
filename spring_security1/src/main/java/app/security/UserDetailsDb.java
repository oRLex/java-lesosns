package app.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
public class UserDetailsDb {

  private final DbUserRepo userRepo;

  private UserDetails mapper(DbUser x) {
    List<GrantedAuthority> allRoles = Arrays.stream(x.getRoles())
      .map(s -> (GrantedAuthority) () -> s)           // hasRole
//      .map(s -> (GrantedAuthority) () -> "ROLE_" + s) // hasAuthority
      .collect(Collectors.toList());

    return User
      .withUsername(x.getUsername())
      .password(x.getPassword())
      .authorities(allRoles)
      .build();
  }

  @Bean
  public UserDetailsService uds() {

//    UserDetailsService uds = (username) -> userRepo.findByUsername(username)
//      .map(u -> mapper(u))
//      .orElseThrow(() -> new UsernameNotFoundException(username));

    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username)
          .map(u -> mapper(u))
          .orElseThrow(() -> new UsernameNotFoundException(username));
      }
    };

  }

}
