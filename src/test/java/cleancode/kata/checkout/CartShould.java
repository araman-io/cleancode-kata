package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.A;
import static cleancode.kata.checkout.Sku.B;
import static cleancode.kata.checkout.Sku.C;
import static cleancode.kata.checkout.Sku.D;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashSet;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

public class CartShould {
  
  @Test
  public void count_sku() throws Exception {
    Cart c = new Cart();
    c.scan(asList(Sku.A, Sku.A, Sku.B));
    assertThat(c.skuCount(Sku.A), is(2));
  }
  
  @Test
  public void return_distinct_skus() throws Exception {
    Cart c = new Cart();
    c.scan(asList(A, B, B, C));
    assertThat(c.skuSet(), is(new HashSet<>(asList(A, B, C))));
  }
  
  @Test
  public void decrement_sku_count_when_sku_is_present() throws Exception {
    Cart c = new Cart();
    c.scan(asList(A, B, B, C));
    c.decrementSkuCountBy(B, 1);
    assertThat(c.skuCount(B), is(1));
  }

  @Test
  public void decrement_sku_count_to_0_when_sku_is_present() throws Exception {
    Cart c = new Cart();
    c.scan(asList(A, B, B, C));
    c.decrementSkuCountBy(C, 1);
    assertThat(c.skuCount(C), is(0));
  }
  
  @Test
  public void not_decrement_sku_count_when_sku_is_not_present() throws Exception {
    Cart c = new Cart();
    c.scan(asList(A, B, B, C));
    c.decrementSkuCountBy(D, 1);
    assertThat(c.skuCount(D), is(0));
  }
  
  @Test
  public void not_decrement_sku_count__below_0_when_more_quantity_requested_to_be_decremented() throws Exception {
    Cart c = new Cart();
    c.scan(asList(A, B, B, C));
    c.decrementSkuCountBy(B, 5);
    assertThat(c.skuCount(B), is(0));
  }
}
