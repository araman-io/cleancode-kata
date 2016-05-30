package cleancode.kata.orderamount.speller;

public class CroreSpeller extends ThousandsSpeller {

  private static final Speller LACS_SPELLER = new LacsSpeller();

  @Override
  protected Speller nextSpeller() {
    return LACS_SPELLER;
  }

  @Override
  protected int getPlaceValue() {
    return 10000000;
  }

  protected String getDenomination() {
    return "crore";
  }

}
