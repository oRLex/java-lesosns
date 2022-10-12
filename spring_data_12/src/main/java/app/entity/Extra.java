package app.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Data
@Entity
public class Extra {

  @Id
  private Long id;

  private String extra;

  @MapsId
  @OneToOne
  private Student student;
}
