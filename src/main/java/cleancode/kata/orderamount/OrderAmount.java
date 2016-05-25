package cleancode.kata.orderamount;

import cleancode.kata.orderamount.speller.LacsSpeller;
import cleancode.kata.orderamount.speller.Speller;

public class OrderAmount {

  private static final Speller HEAD = new LacsSpeller();

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    String result = HEAD.spell(amount);
    return result;
  }

}
