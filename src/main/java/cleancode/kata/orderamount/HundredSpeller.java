package cleancode.kata.orderamount;

import static java.lang.String.format;

public class HundredSpeller extends AbstractSpeller implements Speller {

  private String[] hundredSpellings =
      {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


  protected String spellThisFragment(int number) {
    int quantum = getQuantum(number);
    return (quantum > 0) ? format("%s hundred", hundredSpellings[quantum]) : "";
  }

  @Override
  protected int getPlaceValue() {
    return 100;
  }

  @Override
  protected Speller nextSpeller() {
    return new TensSpeller();
  }

}
