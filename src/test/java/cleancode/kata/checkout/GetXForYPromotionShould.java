package cleancode.kata.checkout;

import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class GetXForYPromotionShould {
  
  @Test
  public void should_return_offer_price_when_count_matches_threshold() throws Exception {
    Promotion promotion = new GetXForYPromotion(Sku.A, 3, 130);
    assertThat(promotion.evaluateTotal(3), is(130));
  }
  
  @Test
  public void should_return_unit_price_times_quantity_when_count_doesnt_match_threshold() throws Exception {
    Promotion promotion = new GetXForYPromotion(Sku.A, 3, 130);
    assertThat(promotion.evaluateTotal(2), is(100));
  }

  @Test
  public void should_return_offerprice_plus_remaining_unit_price_times_quantity_when_count_exceeds_but_doesnt_match_threshold_perfectly() throws Exception {
    Promotion promotion = new GetXForYPromotion(Sku.A, 3, 130);
    assertThat(promotion.evaluateTotal(5), is(230));
  }

}
