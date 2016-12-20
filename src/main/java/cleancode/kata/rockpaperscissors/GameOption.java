package cleancode.kata.rockpaperscissors;

public enum GameOption {

  ROCK("SCISSORS"), PAPER("ROCK"), SCISSORS("PAPER");
  
  private String winsOver;

  GameOption(String winsOver) {
    this.winsOver = winsOver;
  }
  
  public GameOption winsOver() {
    return valueOf(this.winsOver);
  }

}
