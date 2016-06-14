package cleancode.kata.checkout.promotion;

import static cleancode.kata.checkout.Sku.A;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

import cleancode.kata.checkout.Checkout;

public class NullPromotionShould {
  
  @Test
  public void always_return_unitPrice_times_count() throws Exception {
    Promotion p = new NullPromotion(A);
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, A, A, A, A));
    assertThat(p.evaluateTotal(checkout.cart()), is(250));
    assertThat(p.appliesTo(), is(asList(A)));
  }

  @Test
  public void reset_sku_count() throws Exception {
    Promotion p = new NullPromotion(A);
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, A, A, A, A));
    p.evaluateTotal(checkout.cart());
    assertThat(checkout.cart().skuCount(A), is(0));
  }

}
