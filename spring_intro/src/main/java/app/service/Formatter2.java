package app.service;

import org.springframework.stereotype.Service;

@Service
public class Formatter2 implements Formatter{

  @Override
  public String format(String origin) {
    return origin.toUpperCase();
  }

}
