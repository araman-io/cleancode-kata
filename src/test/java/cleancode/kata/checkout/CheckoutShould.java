package cleancode.kata.checkout;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class CheckoutShould {

  @Test
  public void price_1A_as_50() throws Exception {
    Checkout checkout = new Checkout();
    checkout.scan("A");
    assertThat(checkout.total(), is(50));
  }

  @Test
  public void price_1B_as_30() throws Exception {
    Checkout checkout = new Checkout();
    checkout.scan("B");
    assertThat(checkout.total(), is(30));
  }


  @Test
  public void price_1A_1B_as_80() throws Exception {
    Checkout checkout = new Checkout();
    checkout.scan("A");
    checkout.scan("B");
    assertThat(checkout.total(), is(80));
  }

}
