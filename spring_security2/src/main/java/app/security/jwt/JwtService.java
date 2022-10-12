package app.security.jwt;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Log4j2
@Service
@PropertySource("classpath:jwt.properties")
public class JwtService {

  @Value("${jwt.secret}")
  private String jwtSecret;

  @Value("${jwt.expiration.normal}")
  private Long expiration_normal;

  @Value("${jwt.expiration.remember}")
  private Long expiration_remember;

  private JwtPlain jwt;

  @PostConstruct
  public void mount() {
    jwt = new JwtPlain(
      jwtSecret,
      expiration_normal,
      expiration_remember
    );
  }

  public String encode(Integer id, boolean remember) {
    return jwt.encode(id, remember);
  }

  public Optional<Integer> decode(String rawToken) {
    return jwt.decode(rawToken);
  }

}
