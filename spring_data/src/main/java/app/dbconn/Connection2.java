package app.dbconn;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
@PropertySource({ "classpath:connection2.properties" })
@ToString
public class Connection2 {

  @Value("${datasource2.url}")
  String url;

  @Value("${datasource2.username}")
  String username;

  @Value("${datasource2.password}")
  String password;

//  @Bean
  public LocalContainerEntityManagerFactoryBean userEntityManager() {
    throw new IllegalArgumentException("not implemented");
  }
}
