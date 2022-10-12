package app.dto;

import app.entity.Phone;
import lombok.Value;

import java.util.List;

@Value
public class Person2 {
  String name;
  List<Phone> phones;
}
