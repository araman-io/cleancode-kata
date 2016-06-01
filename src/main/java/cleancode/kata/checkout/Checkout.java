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

  private List<Sku> skus = new ArrayList<>();
  private Map<Sku, Promotion> promotionsBySku = new HashMap<>();

  public Checkout() {
    super();
  }

  public Checkout(Promotion promotion) {
    this(asList(promotion));
  }

  public Checkout(List<Promotion> promotions) {
    this.promotionsBySku = promotions.stream().collect(toMap(Promotion::sku, identity()));
  }

  public void scan(String product) {
    scan(valueOf(product));
  }

  public void scan(Sku product) {
    skus.add(product);
  }

  public void scan(Sku... skus) {
    asList(skus).forEach(sku -> {
      this.skus.add(sku);
    });
  }

  public int total() {
    int totalPrice = 0;

    Map<Sku, Integer> skuCount = new HashMap<>();
    for (Sku sku : skus) {
      Integer existingCount = skuCount.getOrDefault(sku, 0);
      skuCount.put(sku, existingCount + 1);
    }

    totalPrice = skuCount.entrySet().stream().mapToInt(entrySet -> {
      Promotion promotion = promotionFor(entrySet.getKey());
      return promotion.evaluateTotal(entrySet.getValue());
    }).sum();

    return totalPrice;
  }

  private Promotion promotionFor(Sku sku) {
    return promotionsBySku.getOrDefault(sku, new NullPromotion(sku));
  }

}
