package app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class CalcService {

  private final ServerProperties prop;

  public int add(int a, int b) {
    return a + b;
  }

  public Integer convert(String s) {
    return Integer.parseInt(s);
  }

  public void doSomething1(int a, int b) {
    if (a > b) {
      /////
    } else {
      ////
    }
  }

  public void doSomething(int a, int b, int c) {
    if (a > b) {
      if (a > c) {
        ////
      } else {
        ////
      }
    } else {
      if (b > c) {
       ////
      } else {
       ////
      }
    }
  }


  public String readProp() {
    throw new IllegalArgumentException("hi there:)");
//    log.error(prop);
//    log.warn(prop);
//    log.info(prop);
//    log.debug(prop);
//    log.trace(prop);
//    return "path";
  }

}
