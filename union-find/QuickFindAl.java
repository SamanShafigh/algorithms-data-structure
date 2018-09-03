import java.util.Scanner;

/**
 * Quick-find (Eager approach)
 */
public class QuickFindAl {
  /**
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
    System.out.println(qf.stringify());
  }
}


/**
 * Quick-find (Eager approach)
 */
class QuickFind {

  private int[] id;

  /**
   * 
   * @param n
   */
  public QuickFind(int n) {
    id = new int[n];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  /**
   * Check if two node n and m is connected
   * @param n
   * @param m
   * @return
   */
  public boolean connected(int n, int m) {
    return id[n] == id[m];
  }

  /**
   * Connect n to m
   * 
   * @param n
   * @param m
   */
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

  /**
   * Stringify the content of id
   */
  public String stringify() {
    String content = "";
    for (int i = 0; i < id.length; i++) {
      content = content + " node " + i + " is connected to " + id[i] + "\n"; 
    }

    return content;
  }
}