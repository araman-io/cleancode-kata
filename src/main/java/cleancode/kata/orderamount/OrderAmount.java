package cleancode.kata.orderamount;

public class OrderAmount {

  private String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight",
      "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
      "eighteen", "nineteen", "twenty"};

  private String[] tens =
      {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    if (amount <= 20) {
      return units[amount];
    } else {
      int tenCount = amount / 10;
      return tens[tenCount] + " " + units[amount - (tenCount * 10)];
    }
  }

}
