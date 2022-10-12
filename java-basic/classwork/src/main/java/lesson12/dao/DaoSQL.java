package lesson12.dao;

import java.sql.Connection;
import java.util.Optional;
import java.util.Set;

public class DaoSQL<A extends Identifiable> implements DAO<A> {

  private final Connection conn;

  public DaoSQL(Connection conn) {
    this.conn = conn;
  }

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
