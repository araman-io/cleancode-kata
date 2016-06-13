package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.valueOf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

import cleancode.kata.checkout.promotion.NullPromotion;
import cleancode.kata.checkout.promotion.Promotion;

public class Checkout {

  private List<Sku> skus = new ArrayList<>();
  private List<Promotion> promotions = new ArrayList<>();
  private Map<Sku, Integer> skuCount;

  public Checkout() {
    super();
  }

  public Checkout(Promotion promotion) {
    this(asList(promotion));
  }

  public Checkout(List<Promotion> promotions) {
    promotions.forEach(this.promotions::add);
  }

  public void scan(String product) {
    scan(valueOf(product));
  }

  public void scan(Sku product) {
    scan(asList(product));
  }

  public void scan(List<Sku> skus) {
    skus.forEach(sku -> {
      this.skus.add(sku);
    });
    groupCartBySku();
    addNullPromotionsForSkusWithNoConfiguredPromotions();
  }

  public int total() {
    int totalPrice = 0;

    totalPrice = promotions.stream() //
        .mapToInt(p -> {
          return p.evaluateTotal(this);
        }) //
        .sum();

    return totalPrice;
  }

  public boolean contains(Sku sku) {
    return skuCount.containsKey(sku);
  }

  public Integer skuCount(Sku sku) {
    return skuCount.getOrDefault(sku, 0);
  }

  private void groupCartBySku() {
    this.skuCount = new HashMap<>();
    for (Sku sku : skus) {
      Integer existingCount = this.skuCount.getOrDefault(sku, 0);
      this.skuCount.put(sku, existingCount + 1);
    }
  }

  private void addNullPromotionsForSkusWithNoConfiguredPromotions() {
    Set<Sku> cartSkus = new HashSet<>(skus);
    Set<Sku> promotionSkus = new HashSet<>();
    
    promotions.stream() //
        .map(Promotion::appliesTo)//
        .forEach(promotionSkus::addAll);

    cartSkus.stream() //
        .filter(s -> {
          return !promotionSkus.contains(s) ? true : false;
        }) //
        .forEach(s -> {
          this.promotions.add(new NullPromotion(s));
        });
  }

}
