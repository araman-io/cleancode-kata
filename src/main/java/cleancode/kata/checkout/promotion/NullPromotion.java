package cleancode.kata.checkout.promotion;

import java.util.List;

import static java.util.Arrays.asList;

import cleancode.kata.checkout.Cart;
import cleancode.kata.checkout.Sku;

public class NullPromotion implements Promotion {

  private Sku sku;

  public NullPromotion(Sku sku) {
    this.sku = sku;
  }

  @Override
  public int evaluateTotal(Cart cart) {
    int result = sku.unitPrice() * cart.skuCount(sku);
    cart.resetSkuCount(sku);
    return result;
  }

  @Override
  public List<Sku> appliesTo() {
    return asList(sku);
  }

  @Override
  public String toString() {
    return "NullPromotion [sku=" + sku + "]";
  }


}
