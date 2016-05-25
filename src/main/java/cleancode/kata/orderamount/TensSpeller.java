package cleancode.kata.orderamount;

public class TensSpeller extends AbstractSpeller implements Speller {

  private String[] unitTeenSpellings = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
      "sixteen", "seventeen", "eighteen", "nineteen"};

  private static final UnitSpeller NEXT_SPELLER = new UnitSpeller();

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  protected String spellThisFragment(int number) {
    if (number > 10 && number < 20) {
      return unitTeenSpellings[number - 10];
    } else {
      int quantum = number / getPlaceValue();
      return (quantum > 0) ? tensSpellings[quantum] : "";
    }
  }

  protected Speller nextSpeller() {
    return NEXT_SPELLER;
  }

  protected int getPlaceValue() {
    return 10;
  }

  @Override
  protected int nextPart(int number, int quantum) {
    if (number > 10 && number < 20) {
      return 0;
    } else {
      return super.nextPart(number, quantum);
    }
  }


}
