/**
 * Quick-union (Eager approach)
 */
public class QuickUnionAlg {
  public static void main(String[] args) {
    QuickUnion qu = new QuickUnion(10);
    qu.union(2, 3);
    qu.union(4, 5);
    qu.union(1, 3);
    qu.union(7, 6);
    
    System.out.println(qu.connected(2, 3));
    System.out.println(qu.connected(1, 2));
    System.out.println(qu.connected(8, 9));
  }
}

class QuickUnion {

  private int[] nodes;

  public QuickUnion(int size) {
    nodes = new int[size];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = i;
    }
  }

  public int root(int n) {
    while (n != nodes[n]) {
      n = nodes[n];
    }

    return n;
  }

  public boolean connected(int n, int m) {
    return root(n) == root(m);
  }

  public void union(int n, int m) {
    if (connected(n, m)) {
      return;
    }

    int nRoot = root(n);
    int mRoot = root(m);
    nodes[nRoot] = mRoot;
  }
}