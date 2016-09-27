package cleancode.kata.sortingballs;

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
    List<String> emptyList = new ArrayList<>();
    assertThat(game.draws(), is(emptyList));
  }
  
  @Test
  public void returnsOneBallWhenOneBallHasBeenDrawn() {
    Game game = new Game();
    game.draw("57");
    List<String> expected = asList("57");
    assertThat(game.draws(), is(expected));
  }

}
