package cleancode.kata.orderamount;

public class TensAndUnitsSpeller extends AbstractSpeller implements Speller {

  private String[] unitTeenSpellings = {"", "one", "two", "three", "four", "five", "six", "seven",
      "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
      "seventeen", "eighteen", "nineteen"};

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  protected String spellThisFragment(int number) {
    int quantum = number / getPlaceValue();
    String result = "";

    if (number > 0 && number < 20) {
      result = unitTeenSpellings[number];
    }

    if (quantum > 1 && quantum < 100) {
      if (number % getPlaceValue() == 0) {
        result = tensSpellings[quantum];
      } else {
        result = tensSpellings[quantum] + " " + unitTeenSpellings[ number - (quantum * getPlaceValue())];
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
