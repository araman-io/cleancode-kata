package cleancode.kata.checkout.promotion;

import cleancode.kata.checkout.Sku;

public class NullPromotion implements Promotion {

  private Sku sku;
  
  public NullPromotion(Sku sku) {
    this.sku = sku;
  }

  @Override
  public int evaluateTotal(int skuCount) {
    return sku.unitPrice() * skuCount;
  }

  @Override
  public Sku sku() {
    return sku;
  }


}
