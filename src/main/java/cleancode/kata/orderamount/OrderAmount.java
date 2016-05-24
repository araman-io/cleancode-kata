package cleancode.kata.orderamount;

public class OrderAmount {

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    if ( amount == 1 ) {
    return "one";
    } else {
      return "two";
    }
  }

}
