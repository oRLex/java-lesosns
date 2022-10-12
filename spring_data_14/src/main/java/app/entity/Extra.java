package app.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity
public class Extra {
  @Id
  @Column(name = "x_id")
  private Long id;

  @Column(name = "x_extra")
  private String extra;

  @OneToOne(mappedBy = "extra")
  private Student student;
}
