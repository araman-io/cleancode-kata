package cleancode.kata.checkout.promotion;

import cleancode.kata.checkout.Cart;
import cleancode.kata.checkout.Sku;

public class GetXForYPromotion implements Promotion {

  private int thresholdCount;
  private int offerPrice;
  private Sku sku;

  public GetXForYPromotion(Sku sku, int count, int offerPrice) {
    this.sku = sku;
    this.thresholdCount = count;
    this.offerPrice = offerPrice;
  }

  public int evaluateTotal(Cart cart) {
    int total = 0;
    if (cart.contains(sku)) {
      int thresholdUnits = cart.skuCount(sku) / thresholdCount;
      total =
          offerPrice * thresholdUnits + (sku.unitPrice() * (cart.skuCount(sku) % thresholdCount));
      cart.resetSkuCount(sku);
    }
    return total;
  }

}
