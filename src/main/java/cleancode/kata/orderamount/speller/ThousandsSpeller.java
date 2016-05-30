package cleancode.kata.orderamount.speller;

public class ThousandsSpeller extends TensAndUnitsSpeller {

  private static final Speller HUNDREDS_SPELLER = new HundredSpeller();

  @Override
  protected String spellThisFragment(int number) {
    int quantum = number / getPlaceValue();
    String result = super.spellThisFragment(quantum);
    return result.isEmpty() ? "" : result + " " + getDenomination();
  }

  @Override
  protected Speller nextSpeller() {
    return HUNDREDS_SPELLER;
  }

  @Override
  protected int getPlaceValue() {
    return 1000;
  }

  protected String getDenomination() {
    return "thousand";
  }


}
