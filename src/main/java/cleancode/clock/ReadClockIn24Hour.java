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

    result = readDigits(clock.hour()) + " " + readMinutes(clock.minute());

    return result;
  }

  private String readMinutes(int minute) {
    return clock.minute() == 00 ? "hundred" : readDigits(minute);
  }

  protected String readDigits(int digits) {
    String result;
    if (digits < 10) {
      result = hours[0] + " " + hours[digits];
    } else if (digits >= 10 && digits < 20) {
      result = hours[digits];
    } else {
      result = teens[digits / 10] + " " + hours[digits % 10];
    }
    return result;
  }

}
