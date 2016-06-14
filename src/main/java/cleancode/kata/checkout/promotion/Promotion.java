package cleancode.kata.checkout.promotion;

import cleancode.kata.checkout.Cart;

public interface Promotion {

  public int evaluateTotal(Cart cart);

}
