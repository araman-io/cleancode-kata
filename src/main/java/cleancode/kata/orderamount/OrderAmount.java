package cleancode.kata.orderamount;

import static cleancode.kata.orderamount.speller.IndianSpellingConvention.INSTANCE;

public class OrderAmount {

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    String result = INSTANCE.spell(amount);
    return result;
  }

}
