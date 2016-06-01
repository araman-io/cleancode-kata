package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.valueOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class Checkout {

  private List<Sku> products = new ArrayList<>();
  private Map<Sku, Promotion> configuredPromotions = new HashMap<>();

  public Checkout() {
    super();
  }

  public Checkout(Promotion promotion) {
    this(asList(promotion));
  }

  public Checkout(List<Promotion> promotions) {
    configuredPromotions = promotions.stream().collect(toMap(Promotion::sku, identity()));
  }

  public void scan(String product) {
    scan(valueOf(product));
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

    Map<Sku, Integer> productCount = new HashMap<>();
    for (Sku product : products) {
      Integer existingCount = productCount.getOrDefault(product, 0);
      productCount.put(product, existingCount + 1);
    }

    totalPrice = productCount.entrySet().stream().mapToInt(p -> {
      int promotionPrice = 0;
      Promotion promotion = configuredPromotions.get(p.getKey());
      if (promotion != null && p.getValue() == promotion.thresholdCount()) {
        promotionPrice = promotion.offerPrice();
      } else {
        promotionPrice = p.getValue() * p.getKey().unitPrice();
      }
      return promotionPrice;
    }).sum();

    return totalPrice;
  }

}
