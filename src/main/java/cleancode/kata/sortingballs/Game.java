package cleancode.kata.sortingballs;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class Game {

  List<Draw> allDraws = new ArrayList<>();

  public List<Draw> result() {
    sort(allDraws);
    return allDraws;
  }

  public void draw(Draw ball) {
    allDraws.add(ball);
  }

}
