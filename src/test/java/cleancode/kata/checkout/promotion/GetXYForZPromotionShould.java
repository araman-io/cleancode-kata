package cleancode.kata.checkout.promotion;

import static cleancode.kata.checkout.Sku.A;
import static cleancode.kata.checkout.Sku.B;
import static cleancode.kata.checkout.Sku.C;
import static cleancode.kata.checkout.Sku.D;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

import cleancode.kata.checkout.Checkout;

public class GetXYForZPromotionShould {

  @Test
  public void apply_when_both_A_and_B_are_in_cart() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(A, B));
    assertThat(promotion.evaluateTotal(checkout.cart()), is(65));
  }

  @Test
  public void not_apply_when_both_A_and_B_ARENT_in_cart() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(A, C));
    assertThat(promotion.evaluateTotal(checkout.cart()), is(0));
  }

  @Test
  public void decrement_sku_count_for_both_skus_by_1() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(A, B, C));

    promotion.evaluateTotal(checkout.cart());

    assertThat(checkout.cart().skuCount(A), is(0));
    assertThat(checkout.cart().skuCount(B), is(0));
    assertThat(checkout.cart().skuCount(C), is(1));
  }

  @Test
  public void decrement_sku_count_for_both_skus_only_by_1() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(A, B, A, A, A));

    promotion.evaluateTotal(checkout.cart());

    assertThat(checkout.cart().skuCount(A), is(3));
    assertThat(checkout.cart().skuCount(B), is(0));
    assertThat(checkout.cart().skuCount(C), is(0));
  }

  @Test
  public void order_of_scan_shouldnt_matter() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(B, C, D, A));

    int evaluateTotal = promotion.evaluateTotal(checkout.cart());

    assertThat(evaluateTotal, is(65));
  }

  @Test
  public void only_apply_when_sku_count_is_1_each() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(B, C, D, A));
    checkout.cart().resetSkuCount(A);
    checkout.cart().resetSkuCount(B);

    int evaluateTotal = promotion.evaluateTotal(checkout.cart());

    assertThat(evaluateTotal, is(0));
  }

}
