import java.util.Scanner;

/**
 * Quick-union (Eager approach)
 */
public class QuickUnionAlg {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the size: ");
    int count = scan.nextInt();
    QuickFind qu = new QuickUnion(count);

    System.out.println("Enter a list of number: ");
    while (scan.hasNextInt()) {
        int n = scan.nextInt();
        int m = scan.nextInt();
        qu.union(n, m);
        System.out.println(n + " - " + m);
    }
    
    scan.close();
    System.out.println(qu.stringify());
  }
}

class QuickUnion {

  private int[] id;

  public QuickUnion(int n) {
    id = new int[n];
    for (int i = 0; i < id.length; i++) {
      id[i] = i;
    }
  }

  public int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }

    return i;
  }

  public boolean connected(int n, int m) {
    return root(n) == root(m);
  }

  public void union(int n, int m) {
    if (connected(n, m)) {
      return;
    }

    int nId = root(n);
    int mId = root(m);
    id[nId] = mId;
  }

  public String stringify() {
    String content = "";
    for (int i = 0; i < id.length; i++) {
      content = content + " node " + i + " is connected to " + id[i] + "\n"; 
    }

    return content;
  }
}