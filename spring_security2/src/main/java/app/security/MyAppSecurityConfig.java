package app.security;

import app.security.jwt.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.stream.Stream;

@Log4j2
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class MyAppSecurityConfig extends WebSecurityConfigurerAdapter {

  private final JwtAuthenticationFilter jwtFilter;

  private final String[] API_AUTH = { "/auth/login/**", "/api/login/**", "/api/register/**" };
  private final String[] API_FREE = { "/api/guest/**" };

  private String[] opened_resources() {
    return Stream.of(API_AUTH, API_FREE, new String[]{"/beer/**"})
      .flatMap(Arrays::stream).toArray(String[]::new);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // special settings (3 lines) to enable H2 local connection
    // must be removed in production
    // because CSRF must be enabled and implemented in production
    http.csrf().disable();
    http.headers().frameOptions().disable();
    http.authorizeRequests().antMatchers("/h2-console/**").permitAll();

    // switch off JSESSION cookie
    // this staff brakes standard user logging procedure !!!
    http
      .sessionManagement()
      .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http
      .authorizeRequests()
      .antMatchers(opened_resources()).permitAll()
      .antMatchers("/api/home/**").authenticated()
      .antMatchers("/api/admin/**").hasRole("ADMIN")
      .antMatchers("/api/me/**").hasRole("USER")
      .antMatchers("/api/news/**").hasAnyRole("ADMIN", "USER")
      .anyRequest().authenticated();

    /** core idea */
    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
  }

}
