package cleancode.kata.orderamount;

public class OrderAmount {
  
  private String[] units = {"", "one", "two"};

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    return units[amount];
  }

}
