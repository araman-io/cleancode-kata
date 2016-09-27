package cleancode.kata.sortingballs;

import static java.lang.Integer.parseInt;

import java.util.Objects;

public class Draw implements Comparable<Draw> {

  private String number;

  Draw(String number) {
    this.number = number;
  }

  public static Draw of(String number) {
    return new Draw(number);
  }

  public Integer value() {
    return parseInt(number);
  }

  @Override
  public int hashCode() {
    return number.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    Draw other = (Draw) obj;
    return Objects.equals(number, other.number);
  }

  @Override
  public int compareTo(Draw otherDraw) {
    return value() - otherDraw.value();
  }

  @Override
  public String toString() {
    return "Draw [number=" + number + "]";
  }

}
