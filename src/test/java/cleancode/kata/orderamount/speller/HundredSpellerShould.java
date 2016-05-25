package cleancode.kata.orderamount.speller;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

import cleancode.kata.orderamount.speller.HundredSpeller;

public class HundredSpellerShould {
  
  HundredSpeller speller = new HundredSpeller();
  
  @Test
  public void spell101() {
    assertThat(speller.spell(101), is("one hundred one"));
  }

  @Test
  public void spell527() {
    assertThat(speller.spell(527), is("five hundred twenty seven"));
  }

}
