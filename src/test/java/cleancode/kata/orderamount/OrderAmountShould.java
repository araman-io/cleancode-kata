package cleancode.kata.orderamount;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class OrderAmountShould {
  
  @Test
  public void spellOneAsOne() {
    OrderAmount amount = new OrderAmount(1);
    assertThat(amount.asText(), is("one"));
  }
  
  @Test
  public void spellTwoAsTwo() {
    OrderAmount amount = new OrderAmount(2);
    assertThat(amount.asText(), is("two"));
  }

}
