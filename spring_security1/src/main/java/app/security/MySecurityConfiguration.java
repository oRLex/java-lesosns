package app.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class MySecurityConfiguration extends WebSecurityConfigurerAdapter {

  private final DbUsersInitial initial;

  public MySecurityConfiguration(DbUsersInitial initial) {
    this.initial = initial;
    initial.create();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
      .antMatchers("/resources/**").permitAll()
      .antMatchers("/guest/**").permitAll()
      .antMatchers("/home/**").authenticated()
      .antMatchers("/admin/**").hasRole("ADMIN")
//      .antMatchers("/admin/**").hasAuthority("ADMIN")
      .antMatchers("/me/**").hasRole("USER")
      .antMatchers("/news/**").hasAnyRole("ADMIN", "USER")
      // there is no way to configure requests after this line
      .anyRequest().authenticated();

    http
      .formLogin()
      .permitAll();

  }

}
