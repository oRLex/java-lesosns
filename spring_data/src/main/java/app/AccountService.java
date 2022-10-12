package app;

import io.vavr.Tuple2;

import java.util.Optional;

public class AccountService {

  public Optional<Tuple2<Account, Account>> transfer(Account account1, Account account2, Integer amount) {
    if (account1.amount < amount) return Optional.empty();
    account1.amount -= amount;
    account2.amount += amount;
    return Optional.of(new Tuple2<>(account1, account2));
  }

}
