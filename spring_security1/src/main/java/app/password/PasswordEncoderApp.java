package app.password;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class PasswordEncoderApp {

  static Pbkdf2PasswordEncoder pe = new Pbkdf2PasswordEncoder();

  public static void mainEncode(String[] args) {
    String encoded = pe.encode("123");
    System.out.println(encoded);
  }

  public static void main(String[] args) {
    boolean ok = pe.matches("123",
//    "be6098f2d8a6aa132bcc837f2484a71786cf2ea9f84861d784bbdb8cb3c28c9865d7230788a14409"
    "a954366a69a34f0d9f8c7b5cc91f89887b8fb92994f405c70fb66e869bd43c7cf412977132e823ad"
      );
    System.out.println(ok);
  }
  /**
   * be6098f2d8a6aa132bcc837f2484a71786cf2ea9f84861d784bbdb8cb3c28c9865d7230788a14409
   * 59bde3c95d0807936ee26d1d590b27b9824e298fb2cdc8f434254c92d22e87635daeb28bf9250c98
   * a954366a69a34f0d9f8c7b5cc91f89887b8fb92994f405c70fb66e869bd43c7cf412977132e823ad
   */
}
