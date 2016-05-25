package cleancode.clock;

public class ReadClockIn24Hour {

  private Clock clock;

  String[] hours = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
      "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
      "eigtheen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three"};

  String[] teens = {"", "ten", "twenty", "thirty", "forty", "fifty"};

  public ReadClockIn24Hour(Clock clock) {
    this.clock = clock;
  }

  public String read() {
    String result = "";

    if (clock.isMidnight()) {
      return "midnight";
    }

    if (clock.hour() < 10) {
      result = hours[0] + " " + hours[clock.hour()];
    } else {
      result = hours[clock.hour()];
    }

    if (clock.minute() == 00) {
      result += " hundred";
    } else if (clock.minute() > 0 && clock.minute() < 20) {
      result = result + " " + hours[clock.minute()];
    } else {
      result = result + " " + teens[clock.minute() / 10] + " " + hours[clock.minute() % 10];
    }

    return result;
  }

}
