package app;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue
  private Integer id;
  @Column(name = "name")
  private String name;
}
