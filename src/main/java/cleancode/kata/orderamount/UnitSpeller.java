package cleancode.kata.orderamount;

public class UnitSpeller extends AbstractSpeller implements Speller {

  private String[] unitTeenSpellings =
      {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

  @Override
  protected String spellThisFragment(int number) {
    return unitTeenSpellings[number];
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
