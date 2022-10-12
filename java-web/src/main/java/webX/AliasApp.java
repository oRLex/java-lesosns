package webX;

import web2.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class AliasApp {

  interface SMap<V> extends Map<String, V> {}
  interface FunctionIS extends Function<Integer, String> {}

  public static void main(String[] args) {
    new HashMap<String, Integer>();
    new HashMap<String, String>();
    new HashMap<String, Person>();
  }

}
