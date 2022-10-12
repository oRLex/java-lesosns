package app.controller;

import app.service.Formatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FmtController {

  private final Formatter fmt1;
  private final Formatter fmt2;

  public FmtController(
    @Qualifier("formatter1") Formatter fmt1,
    Formatter fmt2 // @Primary
  ) {
    this.fmt1 = fmt1;
    this.fmt2 = fmt2;
  }
}
