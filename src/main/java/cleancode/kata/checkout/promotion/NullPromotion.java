package cleancode.kata.checkout.promotion;

import java.util.List;

import cleancode.kata.checkout.Cart;
import cleancode.kata.checkout.Sku;

public class NullPromotion implements Promotion {


  public NullPromotion() {}

  @Override
  public int evaluateTotal(Cart cart) {
    int total = cart.getSkuCountMap()//
        .entrySet() //
        .stream() //
        .mapToInt(es -> {
          Sku sku = es.getKey();
          int result = sku.unitPrice() * es.getValue();
          cart.resetSkuCount(sku);
          return result;
        })//
        .sum();

    return total;
  }

  @Override
  public List<Sku> appliesTo() {
    throw new UnsupportedOperationException("applies to all pending items");
  }

  @Override
  public String toString() {
    return "NullPromotion []";
  }

}
