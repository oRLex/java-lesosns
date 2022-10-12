package app.exc;

public class BusinessException extends RuntimeException {
  public BusinessException(Throwable cause) {
    super(cause);
  }

  public BusinessException() {
    super();
  }
}
