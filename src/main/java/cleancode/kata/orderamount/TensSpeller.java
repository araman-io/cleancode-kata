package cleancode.kata.orderamount;

public class TensSpeller implements Speller {

  private static final UnitAndTeensSpeller NEXT_SPELLER = new UnitAndTeensSpeller();

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  public String spell(int number) {
    String thisFragment = "";
    String nextFragment = "";
    int quantum = getQuantum(number);
    thisFragment = (quantum > 1) ? tensSpellings[quantum] : "";
    nextFragment = next(number, quantum);
    return mergeFragments(thisFragment, nextFragment);
  }

  protected String next(int number, int quantum) {
    String nextFragment = NEXT_SPELLER.spell(number - (quantum * getPlaceValue()));
    return nextFragment;
  }

  protected int getQuantum(int number) {
    int quantum = number / getPlaceValue();
    return quantum;
  }

  protected int getPlaceValue() {
    return 10;
  }

  protected String mergeFragments(String first, String second) {
    String merged = "";
    if (first.isEmpty()) {
      merged = second.isEmpty() ? "" : second;
    }
    if (!first.isEmpty()) {
      merged = second.isEmpty() ? first : String.format("%s %s", first, second);
    }
    return merged;
  }

}
