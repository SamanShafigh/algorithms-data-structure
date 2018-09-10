/**
 * Quick-find (Eager approach)
 */
public class QuickFindAlg {
  public static void main(String[] args) {
    QuickFind qf = new QuickFind(10);
    qf.union(2, 3);
    qf.union(4, 5);
    qf.union(1, 3);
    qf.union(7, 6);
    
    System.out.println(qf.connected(2, 3));
    System.out.println(qf.connected(1, 2));
    System.out.println(qf.connected(8, 9));
  }
}

class QuickFind {
  private int[] nodes;

  public QuickFind(int n) {
    nodes = new int[n];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = i;
    }
  }

  public boolean connected(int n, int m) {
    return nodes[n] == nodes[m];
  }

  public void union(int n, int m) {
    if (connected(n, m)) {
      return;
    }

    int nId = nodes[n];
    int mId = nodes[m];
    for (int i = 0; i < nodes.length; i++) {
      if (nodes[i] == nId) {
        nodes[i] = mId;
      }
    }
  }
}