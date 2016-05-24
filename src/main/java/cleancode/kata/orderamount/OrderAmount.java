package cleancode.kata.orderamount;

import static java.lang.String.format;

import java.util.List;

import static java.util.Arrays.asList;

public class OrderAmount {

  List<Speller> spellers =
      asList(new HundredSpeller(), new TensSpeller(), new UnitAndTeensSpeller());

  private int amount;

  public OrderAmount(int amount) {
    this.amount = amount;
  }

  public String asText() {
    String result = "";
    int amountToSpell = amount;

    for (Speller s : spellers) {
      int quantum = amountToSpell / s.placeValue();
      String fragment = s.spell(quantum);

      if (!fragment.isEmpty()) {
        result = result.isEmpty() ? fragment : format("%s %s", result, fragment);
      }

      amountToSpell = amountToSpell - (quantum * s.placeValue());

    }

    return result;
  }

}
