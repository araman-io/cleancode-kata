package cleancode.kata.checkout.promotion;

import cleancode.kata.checkout.Checkout;
import cleancode.kata.checkout.Sku;

public class NullPromotion implements Promotion {

  private Sku sku;
  
  public NullPromotion(Sku sku) {
    this.sku = sku;
  }

  @Override
  public int evaluateTotal(Checkout cart) {
    return sku.unitPrice() * cart.skuCount(sku);
  }

  @Override
  public Sku sku() {
    return sku;
  }


}
