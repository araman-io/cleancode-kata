package cleancode.kata.checkout.promotion;

import cleancode.kata.checkout.Checkout;
import cleancode.kata.checkout.Sku;

public class GetXYForZPromotion implements Promotion {

  private int offerPrice;
  private Sku sku1;
  private Sku sku2;

  public GetXYForZPromotion(Sku sku1, Sku sku2, int offerPrice) {
    this.sku1 = sku1;
    this.sku2 = sku2;
    this.offerPrice = offerPrice;
  }

  @Override
  public Sku sku() {
    return null;
  }

  @Override
  public int evaluateTotal(Checkout cart) {
    return cart.contains(sku1) && cart.contains(sku2) ? offerPrice : 0;
  }

}
