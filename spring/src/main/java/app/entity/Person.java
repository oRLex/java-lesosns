package app.entity;

import app.controller.View;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "person")
public class Person {

  @JsonView({View.FieldSet0.class})
  @Id
  // to enable Postgres sequence
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "p_id")
  private Long id;

  @JsonView({View.Admin.class, View.Guest.class})
  @Column(name = "p_name")
  private String name;

  @Column(name = "p_sur_name")
  private String sur_name;

  @JsonView({View.Admin.class})
  @Column
  private String extra;

  @Column
  private String details;

  /**
   * @OneToMany
   * that's not a column
   * that's a field to keep a relation on Java LEVEL
   *
   * @OneToMany(mappedBy="person")"
   * `person` is a field name on the `related entity` (Phone)
   *
   */
  @JsonView({View.Guest.class})
  @OneToMany(cascade = CascadeType.ALL,
//    fetch = FetchType.EAGER // select * from person p join phones on (phones.p == p.id)
    fetch = FetchType.LAZY // select * from person + select * from phone
//  )
  , mappedBy = "person")
//  @JoinTable
//    (name = "r_person_phone",
//      inverseJoinColumns =
//        { @JoinColumn(name = "phone_id", referencedColumnName = "ph_id") },
//      joinColumns =
//        { @JoinColumn(name = "person_id", referencedColumnName = "p_id") }
//    )
  @JsonManagedReference
  private List<Phone> phones = new ArrayList<>();

  public static Person of(String name) {
    return new Person(null, name, null, null, null, null);
  }

  public static Person of(String name, List<Phone> phones) {
    return new Person(null,null, null, name, null, phones);
  }

  public void addPhone(Phone phone) {
    phones.add(phone);
  }
}
