package lesson12.dao;

import java.util.Optional;
import java.util.Set;

/**
 * C - create
 * R - read
 * U - update
 * D - delete
 */
public interface DAO<A extends Identifiable> {
  void create(A a);
  void delete(int id);
  default void delete(A a) {
    delete(a.id);
  }
  void update(A a);
  Optional<A> get(int id);
  Set<A> getAll();
}
