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
    String result = "";
    if (amount < 20) {
      result = unitsAndTeenSpellings[amount];
    }

    if (amount >= 20 && amount < 100) {
      int tenCount = amount / 10;
      if (amount % 10 != 0) {
        result = tensSpellings[tenCount] + " " + unitsAndTeenSpellings[amount - (tenCount * 10)];
      } else {
        result = tensSpellings[tenCount];
      }
    }

    if (amount >= 100) {
      int hundredCount = amount / 100;
      int tenCount = amount / 10;
      result = unitsAndTeenSpellings[hundredCount] + " hundred";
    }

    return result;
  }

}
