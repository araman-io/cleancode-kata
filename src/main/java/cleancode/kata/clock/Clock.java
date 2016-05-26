package cleancode.kata.clock;

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

  public boolean isMidnight() {
    return (hour() == 00 && minute() == 0) ? true : false;
  }

  @Override
  public String toString() {
    return "Clock [time=" + time + "]";
  }


}
