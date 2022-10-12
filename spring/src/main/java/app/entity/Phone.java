package app.entity;

import app.controller.View;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

  @JsonView({View.Guest.class})
  @Column(name = "ph_name")
  private String name;

//  public static Phone of(String ph) {
//    return new Phone(null, ph);
//  }
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
  @JoinTable
    (name = "r_person_phone",
      joinColumns =
        { @JoinColumn(name = "phone_id", referencedColumnName = "ph_id") },
      inverseJoinColumns =
        { @JoinColumn(name = "person_id", referencedColumnName = "p_id") }
    )
  @JsonBackReference
//  @JsonIgnore
  @ToString.Exclude
  private Person person;

}
