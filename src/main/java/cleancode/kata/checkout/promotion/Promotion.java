package cleancode.kata.checkout.promotion;

import java.util.List;

import cleancode.kata.checkout.Checkout;
import cleancode.kata.checkout.Sku;

public interface Promotion {

  public List<Sku> appliesTo();

  public int evaluateTotal(Checkout cart);

}
