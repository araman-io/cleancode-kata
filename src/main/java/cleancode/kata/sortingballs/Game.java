package cleancode.kata.sortingballs;

import java.util.ArrayList;
import java.util.List;

public class Game {

  List<String> allDraws = new ArrayList<>();

  public List<String> result() {
    return allDraws;
  }

  public void draw(String string) {
    allDraws.add(string);
  }

}
