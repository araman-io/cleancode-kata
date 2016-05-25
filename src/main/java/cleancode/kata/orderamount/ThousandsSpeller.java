package cleancode.kata.orderamount;

public class ThousandsSpeller extends AbstractSpeller {

  private String[] unitSpellings =
      {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

  private String[] teenSpellings = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
      "sixteen", "seventeen", "eighteen", "nineteen"};

  private static final Speller HUNDREDS_SPELLER = new HundredSpeller();

  @Override
  protected String spellThisFragment(int number) {
    int quantum = number / getPlaceValue();
    String result = "";
    if (quantum > 0 && quantum <= 10) {
      result = unitSpellings[quantum];
    } else if (quantum > 10 && quantum < 20) {
      result = teenSpellings[quantum - 10];
    }
    return result.isEmpty() ? "" : result + " thousand";
  }

  @Override
  protected Speller nextSpeller() {
    return HUNDREDS_SPELLER;
  }

  @Override
  protected int getPlaceValue() {
    return 1000;
  }

  @Override
  protected int nextPart(int number, int quantum) {
    return number - (quantum * getPlaceValue());
  }

}
