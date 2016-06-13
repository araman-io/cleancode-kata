package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.A;
import static cleancode.kata.checkout.Sku.B;
import static cleancode.kata.checkout.Sku.C;
import static cleancode.kata.checkout.Sku.D;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

import cleancode.kata.checkout.promotion.GetXForYPromotion;

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

  @Test
  public void price_2A_1B_1D_as_130() throws Exception {
    Checkout checkout = new Checkout();
    checkout.scan("A");
    checkout.scan("B");
    checkout.scan(A);
    checkout.scan(D);
    assertThat(checkout.total(), is(145));
  }

  @Test
  public void price_3A_with_3aFor130_promo_as130() throws Exception {
    Checkout checkout = new Checkout(new GetXForYPromotion(A, 3, 130));
    checkout.scan(asList(A, A, A));
    assertThat(checkout.total(), is(130));
  }

  @Test
  public void price_3A_1B_with_3aFor130_promo_as160() throws Exception {
    Checkout checkout = new Checkout(new GetXForYPromotion(A, 3, 130));
    checkout.scan(asList(A, A, A, B));
    assertThat(checkout.total(), is(160));
  }

  @Test
  public void price_3A_2B_with_3aFor130_2Bfor45_promo_as175() throws Exception {
    Checkout checkout =
        new Checkout(asList(new GetXForYPromotion(A, 3, 130), new GetXForYPromotion(B, 2, 45)));
    checkout.scan(asList(A, A, A, B, B));
    assertThat(checkout.total(), is(175));
  }

  @Test
  public void price_4A_2B_1C_with_3aFor130_2Bfor45_promo_as175() throws Exception {
    Checkout checkout =
        new Checkout(asList(new GetXForYPromotion(A, 3, 130), new GetXForYPromotion(B, 2, 45)));
    checkout.scan(asList(A, B, A, B, A, C, A));
    assertThat(checkout.total(), is(245));
  }

  @Test
  public void contain_sku_a_and_not_c() {
    Checkout checkout = new Checkout();
    checkout.scan(A);
    checkout.scan(D);
    assertThat(checkout.contains(A), is(true));
    assertThat(checkout.contains(C), is(false));
  }

  @Test
  public void return_sku_count_if_cart_contains_sku() {
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, D, A, B));
    assertThat(checkout.skuCount(A), is(2));
    assertThat(checkout.skuCount(B), is(1));
    assertThat(checkout.skuCount(C), is(0));
  }

  @Test
  public void return_0_if_cart_doesnt_contain_sku() {
    Checkout checkout = new Checkout();
    checkout.scan(asList(A, D, A, B));
    assertThat(checkout.skuCount(C), is(0));
  }

}
