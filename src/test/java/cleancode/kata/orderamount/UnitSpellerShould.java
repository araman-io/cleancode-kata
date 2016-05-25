package cleancode.kata.orderamount;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class UnitSpellerShould {

  UnitSpeller speller = new UnitSpeller();

  @Test
  public void spell1AsOne() {
    assertThat(speller.spell(1), is("one"));
  }

  @Test
  public void spell0AsEmpty() {
    assertThat(speller.spell(0), is(""));
  }

}
