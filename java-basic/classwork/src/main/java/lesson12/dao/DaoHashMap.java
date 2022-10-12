package lesson12.dao;

import java.util.*;

public class DaoHashMap<A extends Identifiable> implements DAO<A> {

  private final Map<Integer, A> db = new HashMap<>();

  @Override
  public void create(A s) {
    db.put(s.id, s);
  }

  @Override
  public void delete(int id) {
    db.remove(id);
  }

  @Override
  public void update(A s) {
    db.put(s.id, s);
  }

  public Optional<A> get0(int id) {
    A a = db.get(id);
    if (a == null) return Optional.empty();
    return Optional.of(a);
  }

  @Override
  public Optional<A> get(int id) {
    return Optional.ofNullable(db.get(id));
  }

  @Override
  public Set<A> getAll() {
    Set<A> students = new HashSet<>();

    Set<Map.Entry<Integer, A>> entries = db.entrySet();

    for (Map.Entry<Integer, A> pair: entries) {
      A student = pair.getValue();
      students.add(student);
    }

    return students;
  }
}
