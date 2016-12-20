package cleancode.kata.rockpaperscissors;

import static cleancode.kata.rockpaperscissors.GameOption.valueOf;

public class Game {

  public GameOption winnerOf(GameOption firstChoice, GameOption secondChoice) {
    return firstChoice.winsOver() == secondChoice ? firstChoice : secondChoice;
  }

  // method for backward compatibility
  public String winnerOf(String string, String string2) {
    return this.winnerOf(valueOf(string), valueOf(string2)).name();
  }

}
