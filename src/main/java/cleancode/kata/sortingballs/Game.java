package cleancode.kata.sortingballs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.IntStream.range;

public class Game {

  Set<Draw> allDraws = new HashSet<>();

  public List<Draw> result() {
    List<Draw> sortedDraws = new ArrayList<>();

    range(0, allDraws.size()).forEach(index -> {
      Draw nextElement = null;
      for (Draw d : allDraws) {
        if (nextElement == null || nextElement.compareTo(d) > 0) {
          nextElement = d;
        }
      }
      sortedDraws.add(nextElement);
      allDraws.remove(nextElement);
    });
    return sortedDraws;
  }

  public void draw(Draw ball) {
    allDraws.add(ball);
  }

}
