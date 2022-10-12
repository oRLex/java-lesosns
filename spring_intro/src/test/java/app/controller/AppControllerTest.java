package app.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootApplication
class AppControllerTest {

  @Autowired
  private AppController controller;

  @Test
  public void contextLoads() throws Exception {
  }

  @Test
  void servlet1() {
  }
}