package app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Extra {
  @Id
  @GeneratedValue
  private Integer x_id;

  private String extra;

  @OneToOne
  @JoinColumn(name = "s_id")
  private Student student;
}
