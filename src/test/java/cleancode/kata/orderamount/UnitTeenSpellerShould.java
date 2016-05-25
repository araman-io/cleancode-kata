package cleancode.kata.orderamount;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class UnitTeenSpellerShould {
  
  UnitAndTeensSpeller speller = new UnitAndTeensSpeller();
  
  @Test
  public void spell1AsOne() {
    assertThat(speller.spell(1), is("one"));
  }
  
  @Test
  public void spell0AsEmpty() {
    assertThat(speller.spell(0), is(""));
  }
  
  @Test
  public void spell19AsNineteen() {
    assertThat(speller.spell(19), is("nineteen"));
  }


}
