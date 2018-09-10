/**
 * Optimized Quick-union by checking the size of each tree before connecting them 
 * together. The goal is to always add the small tree as a child of large tree. 
 * This strategy insures that the final tree is more flat compare to non optimized 
 * version of this algorithem.
 */
public class WeightedQuickUnionAlg {
  public static void main(String[] args) {
    WeightedQuickUnion qu = new WeightedQuickUnion(10);
    wqu.union(2, 3);
    wqu.union(4, 5);
    wqu.union(1, 3);
    wqu.union(7, 6);
    
    System.out.println(wqu.connected(2, 3));
    System.out.println(wqu.connected(1, 2));
    System.out.println(wqu.connected(8, 9));
  }
}

class WeightedQuickUnion {

  private int[] nodes;
  private int[] weight;

  public WeightedQuickUnion(int size) {
    nodes = new int[size];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = i;
      weight[i] = 1;
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
    if (weight[nRoot] > weight[mRoot]) {
      nodes[mRoot] = nRoot;
      weight[nRoot] += weight[mRoot];
    } else {
      nodes[nRoot] = mRoot;
      weight[mRoot] += weight[nRoot];
    }
  }
}