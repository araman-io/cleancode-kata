package cleancode.kata.orderamount.speller;

public class LacsSpeller extends ThousandsSpeller {

  private static final Speller THOUSANDS_SPELLER = new ThousandsSpeller();

  @Override
  protected Speller nextSpeller() {
    return THOUSANDS_SPELLER;
  }

  @Override
  protected int getPlaceValue() {
    return 100000;
  }
  
  protected String getDenomination() {
    return "lacs";
  }

}
