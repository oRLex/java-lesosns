package app.security.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final JwtService jwt;

  /** shouldn't be here */
  private UserDetails userRemapper(Integer id) {
    return User
      .withUsername(id.toString())
      .password("")
      .authorities(Arrays.asList())
      .build();
  }

  boolean checkIp(Integer token, String remoteAddr) {
    return true;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest rq, HttpServletResponse rs,
      FilterChain filterChain) throws ServletException, IOException {

      extractTokenFromHeaders(rq)
        .flatMap(jwt::decode)
        .filter(t -> checkIp(t, rq.getRemoteAddr()))
        .map(this::userRemapper)
        .map(ud -> new UsernamePasswordAuthenticationToken(ud, null, ud.getAuthorities()))
        .ifPresent(auth -> {
          auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(rq));
          SecurityContextHolder.getContext().setAuthentication(auth);
        });

      filterChain.doFilter(rq, rs);
  }

  private Optional<String> extractTokenFromHeaders(HttpServletRequest rq) {
    return Optional.ofNullable(rq.getHeader(Const.AUTH_HEADER))
      .filter(x -> x.startsWith(Const.AUTH_PREFIX))
      .map(x -> x.substring(Const.AUTH_PREFIX.length()));
  }

}
