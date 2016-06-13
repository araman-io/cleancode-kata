package cleancode.kata.checkout.promotion;

import java.util.List;

import static java.util.Arrays.asList;

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
  public List<Sku> appliesTo() {
    return asList(sku1, sku2);
  }

  @Override
  public int evaluateTotal(Checkout checkout) {
    int result = 0;
    if (checkout.cart.contains(sku1) && checkout.cart.contains(sku2)) {
      result = offerPrice;
      checkout.cart.decrementSkuCountBy(sku1, 1);
      checkout.cart.decrementSkuCountBy(sku2, 1);
    }
    return result;
  }

}
