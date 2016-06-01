package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.valueOf;

import java.util.ArrayList;
import java.util.List;

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
    }
    if (promotion != null && countOfPromotedSku == promotion.thresholdCount()) {
      totalPrice = promotion.getOfferPrice();
    } else {
      totalPrice = products.stream().mapToInt(Sku::unitPrice).sum();
    }
    
    return totalPrice;
  }

}
