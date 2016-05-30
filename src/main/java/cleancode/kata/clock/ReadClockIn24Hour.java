package cleancode.kata.clock;

public class ReadClockIn24Hour {

  private Clock clock;

  String[] unitsAndTeens = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
      "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
      "eigtheen", "nineteen"};

  String[] teens = {"", "ten", "twenty", "thirty", "forty", "fifty"};

  public ReadClockIn24Hour(Clock clock) {
    this.clock = clock;
  }

  public String read() {
    return clock.isMidnight() ? "midnight"
        : readDigits(clock.hour()) + " " + readMinutes(clock.minute());
  }

  private String readMinutes(int minute) {
    return clock.minute() == 00 ? "hundred" : readDigits(minute);
  }

  private String readDigits(int digits) {
    String result;
    if (digits < 10) {
      result = unitsAndTeens[0] + " " + unitsAndTeens[digits];
    } else if (digits >= 10 && digits < 20) {
      result = unitsAndTeens[digits];
    } else {
      result = teens[digits / 10] + " " + unitsAndTeens[digits % 10];
    }
    return result;
  }

}
