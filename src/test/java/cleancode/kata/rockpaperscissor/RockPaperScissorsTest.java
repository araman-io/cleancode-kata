package cleancode.kata.rockpaperscissor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RockPaperScissorsTest {

  @Test
  public void rockWinsOverScissors() {
    assertEquals("ROCK", RockPaperScissors.determineWinner("SCISSORS", "ROCK"));
  }

  @Test
  public void scissorsWinsOverPins() {
    assertEquals("SCISSORS", RockPaperScissors.determineWinner("PAPER", "SCISSORS"));
  }
  
  @Test
  public void paperWinsOverRockPins() {
    assertEquals("PAPER", RockPaperScissors.determineWinner("PAPER", "ROCK"));
  }


}
