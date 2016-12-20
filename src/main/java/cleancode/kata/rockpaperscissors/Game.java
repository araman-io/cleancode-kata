package cleancode.kata.rockpaperscissors;

import static cleancode.kata.rockpaperscissors.GameOption.PAPER;
import static cleancode.kata.rockpaperscissors.GameOption.ROCK;
import static cleancode.kata.rockpaperscissors.GameOption.valueOf;

public class Game {

  public GameOption winnerOf(GameOption firstChoice, GameOption secondChoice) {

    if ((firstChoice == ROCK || secondChoice == ROCK)
        && (firstChoice == PAPER || secondChoice == PAPER)) {
      return PAPER;
    } else {
      return ROCK;
    }
  }

  // method for backward compatibility
  public String winnerOf(String string, String string2) {
    return this.winnerOf(valueOf(string), valueOf(string2)).name();
  }

}
