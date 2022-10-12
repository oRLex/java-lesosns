package app;

import app.dto.Person1Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

//  @Bean
//  public Person1Mapper bean() {
//    return Person1Mapper.INSTANCE;
//  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
