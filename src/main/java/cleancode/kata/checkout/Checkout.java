package cleancode.kata.checkout;

public class Checkout {

  private String product;

  public void scan(String product) {
    this.product = product;
  }

  public int total() {
    return product.equals("A") ? 50 : 30;
  }

}
