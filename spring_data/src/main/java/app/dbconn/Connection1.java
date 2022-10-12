package app.dbconn;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * https://www.baeldung.com/spring-data-jpa-multiple-databases
 */
@Configuration
@PropertySource({ "classpath:connection1.properties" })
@ToString
public class Connection1 {

  @Value("${datasource1.url}")
  String url;

  @Value("${datasource1.username}")
  String username;

  @Value("${datasource1.password}")
  String password;

}
