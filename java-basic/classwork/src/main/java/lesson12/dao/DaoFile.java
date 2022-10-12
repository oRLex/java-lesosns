package lesson12.dao;

import java.util.*;

public class DaoFile<A extends Identifiable> implements DAO<A> {

  @Override
  public void create(A s) {
    throw new IllegalArgumentException("not implemented");
  }

  @Override
  public void delete(int id) {
    throw new IllegalArgumentException("not implemented");
  }

  @Override
  public void update(A s) {
    throw new IllegalArgumentException("not implemented");
  }

  @Override
  public Optional<A> get(int id) {
    throw new IllegalArgumentException("not implemented");
  }

  @Override
  public Set<A> getAll() {
    throw new IllegalArgumentException("not implemented");
  }
}
