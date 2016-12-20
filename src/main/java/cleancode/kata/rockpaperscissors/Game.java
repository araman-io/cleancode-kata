package cleancode.kata.rockpaperscissors;

public class Game {

  public String winnerOf(String string, String string2) {

    if ((string.equals("ROCK") || string2.equals("ROCK"))
        && (string.equals("PAPER") || string2.equals("PAPER"))) {
      return "PAPER";
    } else {
      return "ROCK";
    }
  }

}
