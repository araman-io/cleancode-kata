package cleancode.kata.orderamount;

public class UnitAndTeensSpeller extends AbstractSpeller implements Speller {

  private String[] unitTeenSpellings = {"", "one", "two", "three", "four", "five", "six", "seven",
      "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
      "seventeen", "eighteen", "nineteen"};

  @Override
  protected String spellThisFragment(int number) {
    return (number < 20) ? unitTeenSpellings[number] : this.spell(number % 10);
  }

  @Override
  protected int getPlaceValue() {
    return 1;
  }

  @Override
  protected Speller nextSpeller() {
    return null;
  }

}
