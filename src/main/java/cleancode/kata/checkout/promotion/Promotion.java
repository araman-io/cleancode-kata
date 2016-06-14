package cleancode.kata.checkout.promotion;

import java.util.List;

import cleancode.kata.checkout.Cart;
import cleancode.kata.checkout.Sku;

public interface Promotion {

  public List<Sku> appliesTo();

  public int evaluateTotal(Cart cart);

}
