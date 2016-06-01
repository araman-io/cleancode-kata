package cleancode.kata.checkout;

public interface Promotion {

  public Sku sku();
  
  public int evaluateTotal(int skuCount);

}
