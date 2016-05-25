package cleancode.kata.orderamount;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class TensSpellerShould {
  
  TensSpeller speller = new TensSpeller();
  
  @Test
  public void spell20AsTwenty() {
    assertThat(speller.spell(20), is("twenty"));
  }
  
  @Test
  public void spell30AsThirty() {
    assertThat(speller.spell(30), is("thirty"));
  }
  
  @Test
  public void spell45AsFortyFive() {
    assertThat(speller.spell(45), is("forty five"));
  }
  
  @Test
  public void spell19AsNineteen() {
    assertThat(speller.spell(19), is("nineteen"));
  }



}
