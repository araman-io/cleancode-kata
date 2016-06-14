package cleancode.kata.checkout.promotion;

import static cleancode.kata.checkout.Sku.A;
import static cleancode.kata.checkout.Sku.B;
import static cleancode.kata.checkout.Sku.C;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

import cleancode.kata.checkout.Checkout;

public class NullPromotionShould {


  @Test
  public void always_return_unitPrice_times_count() {
    Promotion p = new NullPromotion();
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, A, A, A, A));
    assertThat(p.evaluateTotal(checkout.cart()), is(250));
  }

  @Test
  public void totals_all_skus_and_reset_sku_count() throws Exception {
    Promotion p = new NullPromotion();
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, B, A, C, B));
    assertThat(p.evaluateTotal(checkout.cart()), is(180));
    assertThat(checkout.cart().skuCount(A), is(0));
    assertThat(checkout.cart().skuCount(B), is(0));
    assertThat(checkout.cart().skuCount(C), is(0));
  }

}
