package cleancode.clock;

import static java.time.ZonedDateTime.parse;
import static org.hamcrest.CoreMatchers.is;

import java.time.ZonedDateTime;

import org.junit.Test;

import static org.junit.Assert.assertThat;

public class ReadClockShould {

  @Test
  public void read09Hour() {
    ZonedDateTime aTime = parse("2016-05-25T09:00:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("zero nine hundred"));
  }

  @Test
  public void read10Hour() {
    ZonedDateTime aTime = parse("2016-05-25T10:00:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("ten hundred"));
  }

  @Test
  public void read17Hour() {
    ZonedDateTime aTime = parse("2016-05-25T17:00:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("seventeen hundred"));
  }

  @Test
  public void read00Hour() {
    ZonedDateTime aTime = parse("2016-05-25T00:00:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("midnight"));
  }

  @Test
  public void read23Hour() {
    ZonedDateTime aTime = parse("2016-05-25T23:00:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("twenty three hundred"));
  }

  @Test
  public void read2359Hour() {
    ZonedDateTime aTime = parse("2016-05-25T23:59:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("twenty three fifty nine"));
  }

  @Test
  public void read2317Hour() {
    ZonedDateTime aTime = parse("2016-05-25T23:17:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("twenty three seventeen"));
  }

  @Test
  public void read1709Hour() {
    ZonedDateTime aTime = parse("2016-05-25T17:09:00.000+01:00");
    Clock clock = new Clock(aTime);
    ReadClockIn24Hour reader = new ReadClockIn24Hour(clock);
    assertThat(reader.read(), is("seventeen zero nine"));
  }

}
