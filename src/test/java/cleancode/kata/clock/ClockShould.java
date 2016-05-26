package cleancode.kata.clock;

import static java.time.ZonedDateTime.now;
import static org.hamcrest.CoreMatchers.is;

import java.time.ZonedDateTime;

import org.junit.Test;

import static org.junit.Assert.assertThat;

import cleancode.kata.clock.Clock;

public class ClockShould {

  @Test
  public void returnCurrentHour() {
    ZonedDateTime now = ZonedDateTime.now();
    Clock c = new Clock(now);
    assertThat(c.hour(), is(now.getHour()));
  }

  @Test
  public void returnCurrentMinute() {
    ZonedDateTime now = ZonedDateTime.now();
    Clock c = new Clock(now);
    assertThat(c.minute(), is(now.getMinute()));
    System.out.println(now);
  }

  @Test
  // slightly flaky test since the hour may change while test runs; but not so frequently as minute
  // or second avoids including a PowerMock dependency
  public void shouldUseZonedDateTimeNowByDefaultToInit() {
    Clock c = new Clock();
    assertThat(c.hour(), is(now().getHour()));
    assertThat(c.minute(), is(now().getMinute()));
  }

}
