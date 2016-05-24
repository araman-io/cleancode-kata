package cleancode.kata.orderamount;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class OrderAmountShould {
  
  @Test
  public void spell1AsOne() {
    OrderAmount amount = new OrderAmount(1);
    assertThat(amount.asText(), is("one"));
  }
  
  @Test
  public void spell2AsTwo() {
    OrderAmount amount = new OrderAmount(2);
    assertThat(amount.asText(), is("two"));
  }
  
  @Test
  public void spell9AsNine() {
    OrderAmount amount = new OrderAmount(9);
    assertThat(amount.asText(), is("nine"));
  }

}
