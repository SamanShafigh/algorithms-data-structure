import java.util.Arrays;

public class ComparableAlg {
  public static void main(String[] args) {
    Date[] dates = new Date[4];
    dates[0] = new Date(2001, 4, 5);
    dates[1] = new Date(2015, 1, 3);
    dates[2] = new Date(1981, 11, 9);
    dates[3] = new Date(2001, 4, 3);
    Arrays.sort(dates);

    for(Date date: dates) {
      System.out.println("date: " + date);
    }
  }
}

class Date implements Comparable<Date> {
  private final int y, m, d;

  public Date(int year, int month, int day) {
    y = year;
    m = month;
    d = day;
  }

  public String toString() {
    return y + "-" + m + "-" + d;
  }

  public int compareTo(Date that) {
    if (this.y < that.y) return -1;
    if (this.y > that.y) return 1;
    if (this.m < that.m) return -1;
    if (this.m > that.m) return 1;
    if (this.d < that.d) return -1;
    if (this.d > that.d) return 1;
    return 0;
  }
}