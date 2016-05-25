package cleancode.kata.orderamount;

public abstract class AbstractSpeller implements Speller {

  protected String spellNext(int number, int quantum) {
    return (nextSpeller() != null) ? nextSpeller().spell(nextPart(number, quantum)) : "";
  }

  protected int nextPart(int number, int quantum) {
    return number - (quantum * getPlaceValue());
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

  protected int getQuantum(int number) {
    int quantum = number / getPlaceValue();
    return quantum;
  }

  protected abstract int getPlaceValue();

  protected abstract Speller nextSpeller();


}
