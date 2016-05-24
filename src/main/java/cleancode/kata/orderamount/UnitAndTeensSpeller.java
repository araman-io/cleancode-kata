package cleancode.kata.orderamount;

public class UnitAndTeensSpeller implements Speller {

  private String[] unitTeenSpellings = {"", "one", "two", "three", "four", "five", "six", "seven",
      "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
      "seventeen", "eighteen", "nineteen"};

  @Override
  public String spell(int number) {
    return (number < 20) ? unitTeenSpellings[number] : this.spell(number % 10);
  }

  @Override
  public int placeValue() {
    return 1;
  }

}
