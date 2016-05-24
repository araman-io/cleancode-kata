package cleancode.kata.orderamount;

public class OrderAmount {

  private String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight",
      "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
      "eighteen", "nineteen"};

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    return units[amount];
  }

}
