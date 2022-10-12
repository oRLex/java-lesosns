package app.beans;

import app.dto.Spiderman;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class Runner {

  private final RestTemplate http;// = new RestTemplate();
  private final ObjectMapper om;

  public String doHttp1(String address, HttpMethod method) {
    throw new IllegalArgumentException("not implemented");
  }

  public List<Spiderman> doHttp2(String address, HttpMethod method) {
    throw new IllegalArgumentException("not implemented");
  }

  public <A> List<A> doHttp3(String address, HttpMethod method, Class<A> clazz) {
    throw new IllegalArgumentException("not implemented");
  }

//  @Bean
  public CommandLineRunner run1() {
    return args -> {
      String url = "http://localhost:8081/student/1";
      Spiderman student = http.getForObject(url, Spiderman.class);
      System.out.println(student);
    };
   }
//  @Bean
  public CommandLineRunner run2() {
    return args -> {
      String url = "http://localhost:8081/student/1";
      String raw = http.getForObject(url, String.class);
      Spiderman student = om.readValue(raw, Spiderman.class);
      System.out.println(student);
    };
   }
//  @Bean
  public CommandLineRunner run3() {
    return args -> {
      String url = "http://localhost:8081/student/1";
      ResponseEntity<Spiderman> entity = http.getForEntity(url, Spiderman.class);
//      if (entity.getStatusCode() != HttpStatus.OK)
      System.out.println(entity.getBody());
    };
   }

  @Bean
  public CommandLineRunner run4() {
    return args -> {
      String url = "http://localhost:8081/student/1";
      // headers
      HttpHeaders headers = new HttpHeaders();
      headers.add("Authorization", ".......");
      headers.add("Token", ".......");
      // entity
      Spiderman jack = new Spiderman(33, "Jack");
      HttpEntity<Object> entity = new HttpEntity<>(headers);
      HttpEntity<Spiderman> postEntity = new HttpEntity<>(jack, headers);

      ResponseEntity<Spiderman> result = http.exchange(url, HttpMethod.GET, entity, Spiderman.class);
//      ResponseEntity<Spiderman> result2 = http.exchange(url, HttpMethod.POST, postEntity, Spiderman.class);
      System.out.println(result.getBody());
    };
   }

}
