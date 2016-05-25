package cleancode.clock;

public class ReadClockIn24Hour {

  private Clock clock;

  private String[] hours =
      {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

  public ReadClockIn24Hour(Clock clock) {
    this.clock = clock;
  }

  public String read() {
    return hours[clock.hour()];
  }

}
