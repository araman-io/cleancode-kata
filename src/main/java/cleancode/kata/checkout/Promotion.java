package cleancode.kata.checkout;

public class Promotion {

  private int thresholdCount;
  private int offerPrice;

  public Promotion(int count, int offerPrice) {
    this.thresholdCount = count;
    this.offerPrice = offerPrice;
  }

  public int thresholdCount() {
    return thresholdCount;
  }

  public int getOfferPrice() {
    return offerPrice;
  }

}
