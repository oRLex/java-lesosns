package a05binarysearch;

import java.util.Objects;
import java.util.Optional;

public class SResult {

  final Optional<Integer> foundAt;
  final Optional<Integer> insertAt;

  private SResult(Optional<Integer> foundAt, Optional<Integer> insertAt) {
    this.foundAt = foundAt;
    this.insertAt = insertAt;
  }

  public static SResult foundAt(int index) {
    return new SResult(Optional.of(index), Optional.empty());
  }

  public static SResult insertAt(int index) {
    return new SResult(Optional.empty(), Optional.of(index));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SResult sResult = (SResult) o;
    return Objects.equals(foundAt, sResult.foundAt) && Objects.equals(insertAt, sResult.insertAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(foundAt, insertAt);
  }
}
