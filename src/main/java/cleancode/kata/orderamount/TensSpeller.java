package cleancode.kata.orderamount;

public class TensSpeller extends AbstractSpeller implements Speller {

  private static final UnitAndTeensSpeller NEXT_SPELLER = new UnitAndTeensSpeller();

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  protected String spellThisFragment(int number) {
    int quantum = number / getPlaceValue();
    return (quantum > 1) ? tensSpellings[quantum] : "";
  }

  protected Speller nextSpeller() {
    return NEXT_SPELLER;
  }

  protected int getPlaceValue() {
    return 10;
  }

  @Override
  protected int nextPart(int number, int quantum) {
    return number;
  }


}
