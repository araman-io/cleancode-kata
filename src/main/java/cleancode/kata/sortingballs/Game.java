package cleancode.kata.sortingballs;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Game {

  List<Draw> allDraws = new ArrayList<>();

  public List<Draw> result() {
    if (allDraws.size() == 2) {
      if (allDraws.get(0).value() > allDraws.get(1).value()) {
        return asList(allDraws.get(1), allDraws.get(0));
      }
    }
    return allDraws;
  }

  public void draw(Draw ball) {
    allDraws.add(ball);
  }

}
