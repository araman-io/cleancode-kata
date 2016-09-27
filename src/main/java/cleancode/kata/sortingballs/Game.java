package cleancode.kata.sortingballs;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Game {

  List<String> allDraws = new ArrayList<>();

  public List<String> result() {
    if ( allDraws.size() == 2 ) {
      if ( parseInt(allDraws.get(0)) > parseInt(allDraws.get(1)) ) {
        return asList(allDraws.get(1), allDraws.get(0));
      }
    }
    return allDraws;
  }

  public void draw(String string) {
    allDraws.add(string);
  }

}
