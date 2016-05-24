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

  @Test
  public void spell10AsTen() {
    OrderAmount amount = new OrderAmount(10);
    assertThat(amount.asText(), is("ten"));
  }

  @Test
  public void spell19AsNineteen() {
    OrderAmount amount = new OrderAmount(19);
    assertThat(amount.asText(), is("nineteen"));
  }

  @Test
  public void spell20AsTwenty() {
    OrderAmount amount = new OrderAmount(20);
    assertThat(amount.asText(), is("twenty"));
  }
  
  @Test
  public void spell21AsTwentyOne() {
    OrderAmount amount = new OrderAmount(21);
    assertThat(amount.asText(), is("twenty one"));
  }
}
