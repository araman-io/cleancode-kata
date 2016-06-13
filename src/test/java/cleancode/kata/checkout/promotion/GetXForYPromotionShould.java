package cleancode.kata.checkout.promotion;

import static cleancode.kata.checkout.Sku.A;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

import cleancode.kata.checkout.Checkout;
import cleancode.kata.checkout.Sku;

public class GetXForYPromotionShould {

  @Test
  public void should_return_offer_price_when_count_matches_threshold() throws Exception {
    Promotion promotion = new GetXForYPromotion(A, 3, 130);
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, A, A));
    assertThat(promotion.evaluateTotal(checkout), is(130));
  }

  @Test
  public void should_return_unit_price_times_quantity_when_count_doesnt_match_threshold()
      throws Exception {
    Promotion promotion = new GetXForYPromotion(Sku.A, 3, 130);
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, A));
    assertThat(promotion.evaluateTotal(checkout), is(100));
  }

  @Test
  public void should_return_offerprice_plus_remaining_unit_price_times_quantity_when_count_exceeds_but_doesnt_match_threshold_perfectly()
      throws Exception {
    Promotion promotion = new GetXForYPromotion(Sku.A, 3, 130);
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, A, A, A, A));
    assertThat(promotion.evaluateTotal(checkout), is(230));
  }

  @Test
  public void should_return_0_when_promotion_doesnt_match_sku() {
    Promotion promotion = new GetXForYPromotion(Sku.A, 3, 130);
    Checkout c = new Checkout(promotion);
    c.scan(Sku.B);
    assertThat(promotion.evaluateTotal(c), is(0));
  }


}
