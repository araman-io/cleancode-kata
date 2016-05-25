package cleancode.kata.orderamount;

public class LacsSpeller extends TensAndUnitsSpeller {

  private static final Speller THOUSANDS_SPELLER = new ThousandsSpeller();

  @Override
  protected String spellThisFragment(int number) {
    int quantum = number / getPlaceValue();
    String result = super.spellThisFragment(quantum);
    return result.isEmpty() ? "" : result + " lacs";
  }

  @Override
  protected Speller nextSpeller() {
    return THOUSANDS_SPELLER;
  }

  @Override
  protected int getPlaceValue() {
    return 100000;
  }

  @Override
  protected int nextPart(int number, int quantum) {
    return number - (quantum * getPlaceValue());
  }

}
