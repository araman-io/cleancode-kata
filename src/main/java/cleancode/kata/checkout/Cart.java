package cleancode.kata.checkout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Cart {

  private List<Sku> skus = new ArrayList<>();
  private Map<Sku, Integer> skuCount = new HashMap<>();

  public Cart() {}

  public void scan(List<Sku> skus) {
    this.skus.addAll(skus);
    groupCartBySku();
  }

  public boolean contains(Sku sku) {
    return skuCount.containsKey(sku);
  }

  public Integer skuCount(Sku sku) {
    return skuCount.getOrDefault(sku, 0);
  }

  public Set<Sku> skuSet() {
    return new HashSet<>(skus);
  }

  private void groupCartBySku() {
    this.skuCount = new HashMap<>();
    for (Sku sku : skus) {
      Integer existingCount = this.skuCount.getOrDefault(sku, 0);
      this.skuCount.put(sku, existingCount + 1);
    }
  }

  public void decrementSkuCountBy(Sku sku, int decrementBy) {
    Integer newCount = this.skuCount(sku) - decrementBy;
    if (newCount < 0) {
      this.skuCount.put(sku, 0);
    } else {
      this.skuCount.put(sku, newCount);
    }
  }

  public void resetSkuCount(Sku sku) {
    this.skuCount.put(sku, 0);
  }

}
