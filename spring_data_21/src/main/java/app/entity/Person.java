package app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Person {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private String phones;

  private final static String DELIMITER = ":";

  public void setPhones(List<String> phones) {
    this.phones = String.join(DELIMITER, phones);
  }

  public List<String> getPhones() {
    return Arrays.stream(phones.split(DELIMITER)).collect(Collectors.toList());
  }
}
