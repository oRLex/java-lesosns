package app.service;

import org.springframework.stereotype.Service;

@Service
public interface Formatter {

  String format(String origin);

}
