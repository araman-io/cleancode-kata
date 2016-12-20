package cleancode.kata.rockpaperscissors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameShould {

  @Test
  public void rockWinsOverScissors() {
    Game g = new Game();
    assertEquals("ROCK", g.winnerOf("ROCK", "SCISSORS"));
  }
  

}
