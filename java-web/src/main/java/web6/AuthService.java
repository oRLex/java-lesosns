package web6;

public class AuthService {

  private int current = 0;

  public int getNext() {
    return ++current;
  }

  public String getNextString() {
    return Integer.toString(++current);
  }

}
