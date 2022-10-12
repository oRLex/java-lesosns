package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "phone")
public class Phone {
  @Id
  // to enable Postgres sequence
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ph_id")
  private Long id;

  @Column(name = "ph_name")
  private String name;

  public static Phone of(String ph) {
    return new Phone(null, ph, null);
  }

  /**
   * that's not a column
   * that's a field to keep a relation on Java LEVEL
   *
   * according to `@JoinTablename = "r_person_phone",...`
   * 3rd table will be created
   * to keep that relation on the Database LEVEL
   */
  @ManyToOne
  private Person person;

}
