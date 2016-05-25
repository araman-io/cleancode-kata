package cleancode.clock;

import static java.time.ZonedDateTime.parse;
import static org.hamcrest.CoreMatchers.is;

import java.time.ZonedDateTime;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ReadClockShould {

  @Test
  public void read09Hour() {
    ZonedDateTime aTime = parse("2016-05-25T09:01:05.531+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("nine"));
  }
  
  @Test
  public void read10Hour() {
    ZonedDateTime aTime = parse("2016-05-25T10:01:05.531+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("ten"));
  }

}
