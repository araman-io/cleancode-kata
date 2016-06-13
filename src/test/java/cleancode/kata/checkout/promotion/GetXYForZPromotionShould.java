package cleancode.kata.checkout.promotion;

import static cleancode.kata.checkout.Sku.A;
import static cleancode.kata.checkout.Sku.B;
import static cleancode.kata.checkout.Sku.C;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

import cleancode.kata.checkout.Checkout;

public class GetXYForZPromotionShould {

  @Test
  public void apply_when_both_A_and_B_are_in_cart() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout cart = new Checkout(promotion);
    cart.scan(asList(A, B));
    assertThat(promotion.evaluateTotal(cart), is(65));
  }

  @Test
  public void not_apply_when_both_A_and_B_ARENT_in_cart() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout cart = new Checkout(promotion);
    cart.scan(asList(A, C));
    assertThat(promotion.evaluateTotal(cart), is(0));
  }

  @Test
  public void return_applicable_skus() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    assertThat(promotion.appliesTo(), is(asList(A, B)));
  }
  
  @Test
  public void decrement_sku_count_for_both_skus_by_1() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(A, B, C));
    
    promotion.evaluateTotal(checkout);
    
    assertThat(checkout.cart.skuCount(A), is(0));
    assertThat(checkout.cart.skuCount(B), is(0));
    assertThat(checkout.cart.skuCount(C), is(1));
  }

  @Test
  public void decrement_sku_count_for_both_skus_only_by_1() throws Exception {
    GetXYForZPromotion promotion = new GetXYForZPromotion(A, B, 65);
    Checkout checkout = new Checkout(promotion);
    checkout.scan(asList(A, B, A, A, A));
    
    promotion.evaluateTotal(checkout);
    
    assertThat(checkout.cart.skuCount(A), is(3));
    assertThat(checkout.cart.skuCount(B), is(0));
    assertThat(checkout.cart.skuCount(C), is(0));
  }

}
