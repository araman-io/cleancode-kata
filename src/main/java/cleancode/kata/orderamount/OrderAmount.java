package cleancode.kata.orderamount;

public class OrderAmount {

  private String[] unitsAndTeenSpellings = {"", "one", "two", "three", "four", "five", "six",
      "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
      "sixteen", "seventeen", "eighteen", "nineteen"};

  private String[] tensSpellings =
      {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    if (amount < 20) {
      return unitsAndTeenSpellings[amount];
    } else {
      int tenCount = amount / 10;
      if (amount % 10 != 0) {
        return tensSpellings[tenCount] + " " + unitsAndTeenSpellings[amount - (tenCount * 10)];
      } else {
        return tensSpellings[tenCount];
      }
    }
  }

}
