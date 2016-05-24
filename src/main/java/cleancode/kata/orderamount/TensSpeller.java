package cleancode.kata.orderamount;

public class TensSpeller implements SpellChain {

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  public String spell(int number) {
    return (number > 1) ? tensSpellings[number] : "";
  }

  @Override
  public int placeValue() {
    return 10;
  }

}
