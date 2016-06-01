package cleancode.kata.checkout.promotion;

import static cleancode.kata.checkout.Sku.A;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class NullPromotionShould {
  
  @Test
  public void always_return_unitPrice_times_count() throws Exception {
    Promotion p = new NullPromotion(A);
    assertThat(p.evaluateTotal(5), is(250));
    assertThat(p.sku(), is(A));
  }

}
