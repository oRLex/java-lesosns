package app.beans;

import app.entity.Person;
import app.entity.Phone;
import app.repository.PersonRepo;
import app.repository.PhoneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class AutoRun {

  private final PhoneRepo phoneRepo;
  private final PersonRepo personRepo;

//  @Bean
  public CommandLineRunner auto1() {
    return args -> {
      personRepo.saveAll(Arrays.asList(
        Person.of("Jim"),
        Person.of("Jack")
      ));
    };
  }

//  @Bean
  public CommandLineRunner auto2() {
    return args -> {
      Person p1 = Person.of("Jim", Arrays.asList(Phone.of("111"), Phone.of("112")));
      personRepo.saveAll(Arrays.asList(
        p1,
        Person.of("Jack", Arrays.asList(Phone.of("311"), Phone.of("312")))
      ));
    };
  }

  @Bean
  public CommandLineRunner auto3() {
    return args -> {
      personRepo.saveAll(Arrays.asList(
        Person.of("Jim", Arrays.asList(Phone.of("111"), Phone.of("112"))),
        Person.of("Jack", Arrays.asList(Phone.of("311"), Phone.of("312")))
      ));
      personRepo.findById(1L).ifPresent(p -> {
        p.addPhone(Phone.of("119"));
        personRepo.save(p);
      });
      System.out.println("--------------------");
      personRepo.findById(1L).ifPresent(p -> {
        System.out.println(p);
      });
    };
  }

}
