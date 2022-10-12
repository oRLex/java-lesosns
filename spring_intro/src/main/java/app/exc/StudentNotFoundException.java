package app.exc;

public class StudentNotFoundException extends BusinessException {
  public final int student_id;

  public StudentNotFoundException(int student_id, Throwable x) {
    super(x);
    this.student_id = student_id;
  }

  public StudentNotFoundException(int student_id) {
    super();
    this.student_id = student_id;
  }
}
