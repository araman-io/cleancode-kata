package cleancode.kata.checkout;

import static cleancode.kata.checkout.Sku.A;
import static cleancode.kata.checkout.Sku.valueOf;

public class Checkout {

  private Sku product;

  public void scan(String product) {
    this.scan(valueOf(product));;
  }

  public void scan(Sku product) {
    this.product = product;
  }
  
  public int total() {
    return product.equals(A) ? 50 : 30;
  }

}
