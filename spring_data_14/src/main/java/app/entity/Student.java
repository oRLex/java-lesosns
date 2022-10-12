package app.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

  @Id
  @GeneratedValue
  @Column(name = "s_id")
  private Long id;

  @Column(name = "s_name")
  private String name;

  @OneToOne
  @JoinTable(name = "r_student_extra",
    joinColumns =
      { @JoinColumn(name = "student_id",
        referencedColumnName = "s_id") },
    inverseJoinColumns =
      { @JoinColumn(name = "extra_id",
        referencedColumnName = "x_id") })
  private Extra extra;
}
