package webYvalidation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ValidationIdeas2 {

  static class Tuple2<A, B> {

    public final A a;
    public final B b;

    public Tuple2(A a, B b) {
      this.a = a;
      this.b = b;
    }

    public static <A1, B1> Tuple2<A1, B1>of (A1 a, B1 b) {
      return new Tuple2<A1, B1>(a, b);
    }

  }

  static String message1 = "string mustn't be empty!";
  static String message2 = "string should be longer that 5 chars";
  static boolean validateNonEmpty(String name) {
    return !name.isEmpty();
  }
  static boolean validateLenGt5(String name) {
    return name.length() > 5;
  }

  interface ValidationResult<A> {
    boolean isValid();
    default boolean isInvalid() { return !isValid(); }
    Optional<A> get();
    Optional<String> message();
  }

  static class Valid<A> implements ValidationResult<A> {

    private final A a;

    Valid(A a) {
      this.a = a;
    }

    @Override
    public boolean isValid() {
      return true;
    }

    @Override
    public Optional<A> get() {
      return Optional.of(a);
    }

    @Override
    public Optional<String> message() {
      return Optional.empty();
    }
  }

  static class Invalid<A> implements ValidationResult<A>{

    private final String message;

    Invalid(String message) {
      this.message = message;
    }

    @Override
    public boolean isValid() {
      return false;
    }

    @Override
    public Optional<A> get() {
      return Optional.empty();
    }

    @Override
    public Optional<String> message() {
      return Optional.of(message);
    }
  }

  static <A> ValidationResult<A> validate(A a, String msg, Predicate<A> cond) {
    if (cond.test(a)) return new Valid<A>(a);
    return new Invalid<A>(msg);
  }

  static <A> ValidationResult<A> validate(A a, String msg, List<Predicate<A>> conds) {
    boolean ok = conds.stream().allMatch(p -> p.test(a));
    if (ok) return new Valid<A>(a);
    return new Invalid<A>(msg);
  }

  static <A> ValidationResult<A> validate(A a, String msg, Predicate<A>... conds) {
    return validate(a, msg, Arrays.asList(conds));
  }

  static <A> ValidationResult<A> validate(A a, Tuple2<Predicate<A>, String>... conds) {
    List<String> errors = Arrays.stream(conds)
      .map(t2 -> validate(a, t2.b, t2.a))
      .filter(x -> x.isInvalid())
      .map(x -> x.message().get())
      .collect(Collectors.toList());

    return errors.isEmpty() ? new Valid<>(a) : new Invalid<>(
      errors.stream().collect(Collectors.joining("\n"))
    );
  }

  public static void main(String[] args) {
    ValidationResult<String> validated1 = validate(
      "Jim",
      message1,
      ValidationIdeas2::validateNonEmpty
    );

    ValidationResult<String> validated2 = validate(
      "Jim",
      message1,
      ValidationIdeas2::validateNonEmpty,
      ValidationIdeas2::validateLenGt5
    );

    if (validated1.isValid()) {}
    Optional<String> name = validated1.get();
    Optional<String> message = validated1.message();
    System.out.println(name); // Optional.of("Jim")
    System.out.println(message); // Optional.empty

    String msg = message.orElse("");
  }

}
