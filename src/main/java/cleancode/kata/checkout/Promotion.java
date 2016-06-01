package cleancode.kata.checkout;

public class Promotion {

  private int thresholdCount;
  private int offerPrice;
  private Sku sku;

  public Promotion(Sku sku, int count, int offerPrice) {
    this.sku = sku;
    this.thresholdCount = count;
    this.offerPrice = offerPrice;
  }

  public Sku sku() {
    return sku;
  }

  public int thresholdCount() {
    return thresholdCount;
  }

  public int offerPrice() {
    return offerPrice;
  }

}
