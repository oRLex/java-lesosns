package app.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.log4j.Log4j2;

import java.util.Date;
import java.util.Optional;

@Log4j2
public class JwtPlain {

  private final String jwtSecret;
  private final Long expiration_normal;
  private final Long expiration_remember;

  public JwtPlain(String jwtSecret, Long expiration_normal, Long expiration_remember) {
    this.jwtSecret = jwtSecret;
    this.expiration_normal = expiration_normal;
    this.expiration_remember = expiration_remember;
  }

  public JwtPlain() {
    this(
      "SGVsbG9Xb3JsZA==",
      86400000L,  // 1d
      864000000L  // 10d
    );
  }

  public String serialize(Integer id) {
    return id.toString();
  }

  public Optional<Integer> deserialize(String raw) {
    try {
      return Optional.of(Integer.parseInt(raw));
    } catch (NumberFormatException x) {
      return Optional.empty();
    }
  }

  public String encode(Integer id, boolean remember_me) {
    final Date now = new Date();
    final Date expiry = new Date(now.getTime() + (remember_me ? expiration_remember : expiration_normal));

    String subject = serialize(id);

    return Jwts.builder()
      .setSubject(subject)
      .setIssuedAt(now)
      .setExpiration(expiry)
      .signWith(SignatureAlgorithm.HS512, jwtSecret)
      .compact();
  }

  public String extractSubject(Jws<Claims> claimsJws) {
    return claimsJws.getBody().getSubject();
  }

  public Optional<Jws<Claims>> tokenToClaims(String token) {
    try {
      return Optional.of(
        Jwts.parser()
          .setSigningKey(jwtSecret)
          .parseClaimsJws(token)
      );
    } catch (SignatureException ex) {
      log.error("JWT: Invalid signature");
    } catch (MalformedJwtException ex) {
      log.error("JWT: Invalid token");
    } catch (ExpiredJwtException ex) {
      log.error("JWT: Expired token");
    } catch (UnsupportedJwtException ex) {
      log.error("JWT: Unsupported token");
    } catch (IllegalArgumentException ex) {
      log.error("JWT: token is empty.");
    }
    return Optional.empty();
  }

  public Optional<Integer> decode(String token) {
    return tokenToClaims(token)
      .map(this::extractSubject)
      .flatMap(this::deserialize);
  }

  public static void main1(String[] args) {
    JwtPlain j = new JwtPlain();
    String token = j.encode(44, true);
    System.out.println(token);
  }

  public static void main2(String[] args) {
    JwtPlain j = new JwtPlain();
    String rawToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0NCIsImlhdCI6MTYzMDEzOTY0NSwiZXhwIjoxNjMxMDAzNjQ1fQ.7um7lo6Ntim6a0b2fyeEw3ssLuhoEqlC30gjwZklMEA0nVG36lSCPaSc0PBhGAo-FiyDBg3l_zWSlD5-sYQc8g";
    Optional<Integer> decoded = j.decode(rawToken);
    System.out.println(decoded);
  }

}
