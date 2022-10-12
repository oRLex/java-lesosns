package lesson07.animals;

public abstract class Animal {

  public abstract void sound();

  public void die() {
    sound();
    System.out.println("end of lifecycle");
  }

}
