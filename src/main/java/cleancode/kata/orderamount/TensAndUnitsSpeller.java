package cleancode.kata.orderamount;

public class TensAndUnitsSpeller extends AbstractSpeller implements Speller {

  private String[] unitTeenSpellings = {"", "one", "two", "three", "four", "five", "six", "seven",
      "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
      "seventeen", "eighteen", "nineteen"};

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  protected String spellThisFragment(int number) {
    String result = "";

    if (number > 0 && number < 20) {
      result = unitTeenSpellings[number];
    } else if (number >= 20 && number < 100) {
      if (number % 10 == 0) {
        result = tensSpellings[number / 10];
      } else {
        result = tensSpellings[number / 10] + " " + unitTeenSpellings[number % 10];
      }
    }

    return result;
  }

  protected Speller nextSpeller() {
    return null;
  }

  protected int getPlaceValue() {
    return 10;
  }

}
