package cleancode.kata.sortingballs;

import java.util.ArrayList;
import java.util.List;

public class Game {

  List<String> result = new ArrayList<>();

  public List<String> draws() {
    return result;
  }

  public void draw(String string) {
    result.add(string);
  }

}
