import java.util.Arrays;

public class SelectionSortAlg {
  public static void main(String[] args) {
    Date[] dates = new Date[4];
    dates[0] = new Date(2001, 4, 5);
    dates[1] = new Date(2015, 1, 3);
    dates[2] = new Date(1981, 11, 9);
    dates[3] = new Date(2001, 4, 3);
    SelectionSort.sort(dates);

    for(Date date: dates) {
      System.out.println("date: " + date);
    }
  }
}

class SelectionSort {
  public static void sort(Comparable[] items) {
    int n = items.length;
    for (int i = 0; i < n; i++) {
      int min = i;
      for (int j = i+1; j < n; j++) {
        if (less(items[j], items[min])) {
          min = j;
        }
      }
      exchange(items, i, min);
    }
  }

  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) == -1;
  }

  private static void exchange(Comparable[] items, int i, int j) {
    Comparable swap = items[i];
    items[i] = items[j];
    items[j] = swap;
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


