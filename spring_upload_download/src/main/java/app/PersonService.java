package app;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PersonService {

  AtomicInteger counter = new AtomicInteger(4);

  private final Map<Integer, Person> data = new HashMap<Integer, Person>() {{
    put(1, new Person(1, "jim"));
    put(2, new Person(2, "jack"));
    put(3, new Person(3, "jeremy"));
  }};

  public Collection<Person> getAll() {
    return data.values();
  }

  public Optional<Person> getOne(Integer id) {
    return Optional.ofNullable(data.get(id));
  }

  public void add(Person p) {
    int id = counter.getAndIncrement();
    p.setId(id);
    data.put(p.getId(), p);
  }

  public boolean update(Person p) {
    if (!data.containsKey(p.getId())) return false;

    data.put(p.getId(), p);
    return true;
  }

  public boolean remove(Integer id) {
    if (!data.containsKey(id)) return false;

    data.remove(id);
    return true;
  }

  public void die() {
    throw new IllegalArgumentException("went too bad");
  }
}
