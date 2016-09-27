package cleancode.kata.sortingballs;

import static cleancode.kata.sortingballs.Draw.of;
import static org.hamcrest.CoreMatchers.is;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static java.util.Arrays.asList;

import static org.junit.Assert.assertThat;

public class GameShould {
  
  @Test
  public void returnNoBallsWhenCreated() {
    Game game = new Game();
    List<Draw> emptyList = new ArrayList<>();
    assertThat(game.result(), is(emptyList));
  }
  
  @Test
  public void returnOneBallWhenOnlyOneBallHasBeenDrawn() {
    Game game = new Game();
    game.draw(of("57"));
    
    List<Draw> expected = asList(of("57"));
    
    assertThat(game.result(), is(expected));
  }
  
  @Test
  public void returnBallsInTheSameOrderWhen2BallsAreDrawnInAscendingOrder() {
    Game game = new Game();
    game.draw(of("49"));
    game.draw(of("57"));
    
    List<Draw> expected = asList(of("49"), of("57"));
    
    assertThat(game.result(), is(expected));
  }
  
  @Test
  public void returnBallsInAscendingOrderWhen2BallsAreDrawnInDescendingOrder() {
    Game game = new Game();
    game.draw(of("45"));
    game.draw(of("24"));
    
    List<Draw> expected = asList(of("24"), of("45"));
    
    assertThat(game.result(), is(expected));
  }
  
  @Test
  public void returnBallsInAscendingOrderWhen3BallsAreDrawnInDescendingOrder() {
    Game game = new Game();
    game.draw(of("45"));
    game.draw(of("30"));
    game.draw(of("10"));
    
    List<Draw> expected = asList(of("10"), of("30"), of("45"));
    
    assertThat(game.result(), is(expected));
  }

}
