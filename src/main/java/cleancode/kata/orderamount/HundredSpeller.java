package cleancode.kata.orderamount;

public class HundredSpeller implements Speller {

  private String[] hundredSpellings =
      {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


  public String spell(int number) {
    return (number > 0) ? hundredSpellings[number] + " hundred" : "";
  }

  public int placeValue() {
    return 100;
  }

}
