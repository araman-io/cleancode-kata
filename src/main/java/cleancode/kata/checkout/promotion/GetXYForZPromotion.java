package cleancode.kata.checkout.promotion;

import java.util.List;

import static java.util.Arrays.asList;

import cleancode.kata.checkout.Cart;
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
  public int evaluateTotal(Cart cart) {
    int result = 0;
    if (cart.contains(sku1) && cart.contains(sku2) && cart.skuCount(sku1) > 0
        && cart.skuCount(sku2) > 0) {
      result = offerPrice;
      cart.decrementSkuCountBy(sku1, 1);
      cart.decrementSkuCountBy(sku2, 1);
    }
    return result;
  }

}
