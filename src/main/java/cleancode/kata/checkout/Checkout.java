package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.valueOf;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

  private List<Sku> products = new ArrayList<>();

  public void scan(String product) {
    scan(valueOf(product));;
  }

  public void scan(Sku product) {
    products.add(product);
  }

  public int total() {
    return products.stream().mapToInt(Sku::unitPrice).sum();
  }

}
