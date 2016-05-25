package cleancode.kata.orderamount;

public class TensSpeller implements Speller {

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  public String spell(int number) {
    int quantum = number / 10;
    return (quantum > 1) ? tensSpellings[quantum] : "";
  }

}
