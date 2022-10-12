package app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Student {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @OneToOne(mappedBy = "student")
  private Extra extra;
}
