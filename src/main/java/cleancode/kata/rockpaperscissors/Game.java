package cleancode.kata.rockpaperscissors;

public class Game {

  public String winnerOf(String firstChoice, String secondChoice) {

    if ((firstChoice.equals("ROCK") || secondChoice.equals("ROCK"))
        && (firstChoice.equals("PAPER") || secondChoice.equals("PAPER"))) {
      return "PAPER";
    } else {
      return "ROCK";
    }
  }

}
