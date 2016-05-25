package cleancode.kata.orderamount;

public class TensSpeller implements Speller {

  private String[] tensSpellings =
      {"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

  @Override
  public String spell(int number) {
    int quantum = number / 10;
    String result = "";
    result = (quantum > 1) ? tensSpellings[quantum] : "";
    String nextFragment = new UnitAndTeensSpeller().spell(number - (quantum * 10));
    result += nextFragment.isEmpty() ? "" : String.format(" %s",nextFragment);
    return result;
  }

}
