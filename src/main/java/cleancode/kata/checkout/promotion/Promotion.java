package cleancode.kata.checkout.promotion;

import cleancode.kata.checkout.Sku;

public interface Promotion {

  public Sku sku();
  
  public int evaluateTotal(int skuCount);

}
