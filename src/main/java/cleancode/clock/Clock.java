package cleancode.clock;

import static java.time.ZonedDateTime.now;

import java.time.ZonedDateTime;

public class Clock {

  private ZonedDateTime time;

  public Clock(ZonedDateTime aDateTime) {
    this.time = aDateTime;
  }

  public Clock() {
    this.time = now();
  }

  public int hour() {
    return time.getHour();
  }

  public int minute() {
    return time.getMinute();
  }

  @Override
  public String toString() {
    return "Clock [time=" + time + "]";
  }


}
