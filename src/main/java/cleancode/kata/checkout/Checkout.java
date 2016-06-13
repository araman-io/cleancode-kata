package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.valueOf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

import cleancode.kata.checkout.promotion.NullPromotion;
import cleancode.kata.checkout.promotion.Promotion;

public class Checkout {

  private List<Promotion> promotions = new ArrayList<>();
  public Cart cart = new Cart();

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
    this.cart.scan(skus);
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

  private void addNullPromotionsForSkusWithNoConfiguredPromotions() {
    Set<Sku> cartSkus = this.cart.skuSet();
    Set<Sku> promotionSkus = new HashSet<>();
    this.promotions.forEach(p -> {
      promotionSkus.addAll(p.appliesTo());
    });

    cartSkus.removeAll(promotionSkus);
    cartSkus.forEach(s -> {
      this.promotions.add(new NullPromotion(s));
    });
  }

}
