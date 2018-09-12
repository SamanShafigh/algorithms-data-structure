/**
 * Quick-find (Eager approach)
 */
class QuickUnionAlg {
  public static main(): void {
    const qu = new QuickUnion(10);
    qu.union(2, 3);
    qu.union(4, 5);
    qu.union(1, 3);
    qu.union(7, 6);
    
    console.log(qu.connected(2, 3));
    console.log(qu.connected(1, 2));
    console.log(qu.connected(8, 9));
  }
}

class QuickUnion {
  private nodes: number[]

  constructor(size: number) {
    this.nodes = new Array(size);
    for (let i = 0; i < size; i++) {
      this.nodes[i] = i;
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
    this.nodes[nRoot] = mRoot;
  }
}

QuickUnionAlg.main();