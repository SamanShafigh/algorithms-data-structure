import java.util.Scanner;

/**
 * Quick-find (Eager approach)
 */
public class QuickFind {

  private int[] id;

  public QuickFind(int n) {
    id = new int[n];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public void union(int n, int m) {
    if (connected(n, m)) {
      return;
    }

    int nId = id[n];
    int mId = id[m];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == nId) {
        id[i] = mId;
      }
    }
  }

  public String toString() {
    String content = "";
    for (int i = 0; i < id.length; i++) {
      content = content + " node " + i + " is connected to " + id[i] + "\n"; 
    }

    return content;
  }

  /**
   * javac QuickFind.java && java QuickFind
   * 
   * Reads in a sequence of pairs of integers (between 0 and n-1) from standard input, 
   * where each integer represents some site;
   * if the sites are in different components, merge the two components
   * and print the pair to standard output.
   *
   * @param args the command-line arguments
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the size: ");
    int count = scan.nextInt();
    QuickFind qf = new QuickFind(count);

    System.out.println("Enter a list of number: ");
    while (scan.hasNextInt()) {
        int n = scan.nextInt();
        int m = scan.nextInt();
        qf.union(n, m);
        System.out.println(n + " - " + m);
    }
    
    scan.close();
    System.out.println(qf.toString());
  }
}