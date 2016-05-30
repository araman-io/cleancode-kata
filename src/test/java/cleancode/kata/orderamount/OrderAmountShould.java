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
  
  @Test
  public void spell29AsTwentyNine() {
    OrderAmount amount = new OrderAmount(29);
    assertThat(amount.asText(), is("twenty nine"));
  }
  
  @Test
  public void spell45AsFortyFive() {
    OrderAmount amount = new OrderAmount(45);
    assertThat(amount.asText(), is("forty five"));
  }
  
  @Test
  public void spell69AsSixtyNine() {
    OrderAmount amount = new OrderAmount(69);
    assertThat(amount.asText(), is("sixty nine"));
  }
  
  @Test
  public void spell98AsNinetyEight() {
    OrderAmount amount = new OrderAmount(98);
    assertThat(amount.asText(), is("ninety eight"));
  }

  @Test
  public void spell100AsOneHundred() {
    OrderAmount amount = new OrderAmount(100);
    assertThat(amount.asText(), is("one hundred"));
  }

  @Test
  public void spell1000() {
    OrderAmount amount = new OrderAmount(1000);
    assertThat(amount.asText(), is("one thousand"));
  }

  @Test
  public void spell19000() {
    OrderAmount amount = new OrderAmount(19000);
    assertThat(amount.asText(), is("nineteen thousand"));
  }
  
  @Test
  public void spell25000() {
    OrderAmount amount = new OrderAmount(25000);
    assertThat(amount.asText(), is("twenty five thousand"));
  }
  
  @Test
  public void spell99717() {
    OrderAmount amount = new OrderAmount(99717);
    assertThat(amount.asText(), is("ninety nine thousand seven hundred seventeen"));
  }
  
  @Test
  public void spell7489654() {
    OrderAmount amount = new OrderAmount(7489654);
    assertThat(amount.asText(), is("seventy four lacs eighty nine thousand six hundred fifty four"));
  }
  
  
  @Test
  public void spell177489654() {
    OrderAmount amount = new OrderAmount(177489654);
    assertThat(amount.asText(), is("seventeen crore seventy four lacs eighty nine thousand six hundred fifty four"));
  }


}
