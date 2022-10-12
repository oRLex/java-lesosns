package app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

  @Id
  @GeneratedValue
  private Long s_id;

  private String name;

  @OneToOne(mappedBy = "student")
  private Extra extra;
}
