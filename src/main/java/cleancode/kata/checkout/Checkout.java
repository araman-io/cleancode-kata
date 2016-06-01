package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.valueOf;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Checkout {

  private List<Sku> products = new ArrayList<>();
  private Promotion promotion;
  private Sku promotedSku;

  public Checkout() {
    super();
  }

  public Checkout(Sku promotedSku, Promotion promotion) {
    this.promotedSku = promotedSku;
    this.promotion = promotion;
  }

  public void scan(String product) {
    scan(valueOf(product));;
  }

  public void scan(Sku product) {
    products.add(product);
  }

  public void scan(Sku... skus) {
    asList(skus).forEach(sku -> {
      products.add(sku);
    });
  }

  public int total() {
    int totalPrice = 0;

    long countOfPromotedSku = 0l;

    if (promotion != null) {
      countOfPromotedSku = products//
          .stream() //
          .filter(p -> {
            return p.equals(promotedSku);
          }) //
          .count();
      if (countOfPromotedSku == promotion.thresholdCount()) {
        totalPrice = promotion.getOfferPrice();
      }
    }

    totalPrice += products.stream().filter(p -> {
      return !p.equals(promotedSku);
    }).mapToInt(Sku::unitPrice).sum();

    return totalPrice;
  }

}
