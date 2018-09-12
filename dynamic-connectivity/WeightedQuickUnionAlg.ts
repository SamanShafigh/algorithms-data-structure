/**
 * Optimized Quick-union by checking the size of each tree before connecting them 
 * together. The goal is to always add the small tree as a child of large tree. 
 * This strategy insures that the final tree is more flat compare to non optimized 
 * version of this algorithem.
 */
class WeightedQuickUnionAlg {
  public static main(): void {
    const wqu = new WeightedQuickUnion(10);
    wqu.union(2, 3);
    wqu.union(4, 5);
    wqu.union(1, 3);
    wqu.union(7, 6);
    
    console.log(wqu.connected(2, 3));
    console.log(wqu.connected(1, 2));
    console.log(wqu.connected(8, 9));
  }
}

class WeightedQuickUnion {
  private nodes: number[]
  private weight: number[]

  constructor(size: number) {
    this.nodes = new Array(size);
    this.weight = new Array(size);
    for (let i = 0; i < size; i++) {
      this.nodes[i] = i;
      this.weight[i] = 1;
    }    
  }

  public root (n: number) {
    while (n !== this.nodes[n]) {
      n = this.nodes[n];
    }

    return n;
  }

  public connected(n: number, m: number): boolean {
    return this.root(n) === this.root(m);
  }

  public union(n: number, m: number): void {
    if (this.connected(n, m)) {
      return;
    }

    var nRoot = this.root(n)
    var mRoot = this.root(m)
    if (this.weight[nRoot] > this.weight[mRoot]) {
      this.nodes[mRoot] = nRoot;
      this.weight[nRoot] += this.weight[mRoot]
    } else {
      this.nodes[nRoot] = mRoot;
      this.weight[mRoot] += this.weight[nRoot]
    }
  }
}

WeightedQuickUnionAlg.main();