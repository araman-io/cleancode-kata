package cleancode.kata.orderamount;

import static java.lang.String.format;

public class HundredSpeller extends AbstractSpeller implements Speller {

  private String[] hundredSpellings =
      {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


  public String spell(int number) {
    String thisFragment = "";
    String nextFragment = "";
    int quantum = getQuantum(number);
    thisFragment = (quantum > 0) ? format("%s hundred", hundredSpellings[quantum]) : "";
    nextFragment = spellNext(number, quantum);
    return mergeFragments(thisFragment, nextFragment);
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
