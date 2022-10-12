package app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "person")
public class Person {

  @Id
  // to enable Postgres sequence
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "p_id")
  private Long id;

  @Column(name = "p_name")
  private String name;

  /**
   * @OneToMany
   * that's not a column
   * that's a field to keep a relation on Java LEVEL
   *
   * @OneToMany(mappedBy="person")"
   * `person` is a field name on the `related entity` (Phone)
   *
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable
    (name = "r_person_phone",
      inverseJoinColumns =
        { @JoinColumn(name = "phone_id", referencedColumnName = "ph_id") },
      joinColumns =
        { @JoinColumn(name = "person_id", referencedColumnName = "p_id") }
    )
  private List<Phone> phones = new ArrayList<>();

  public static Person of(String name) {
    return new Person(null, name, null);
  }

  public static Person of(String name, List<Phone> phones) {
    return new Person(null, name, phones);
  }

  public void addPhone(Phone phone) {
    phones.add(phone);
  }
}
