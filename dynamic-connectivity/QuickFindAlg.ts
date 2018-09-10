/**
 * Quick-find (Eager approach)
 */
class QuickFindAlg {
  public static main(): void {
    const qf = new QuickFind(10);
    qf.union(2, 3);
    qf.union(4, 5);
    qf.union(1, 3);
    qf.union(7, 6);
    
    console.log(qf.connected(2, 3));
    console.log(qf.connected(1, 2));
    console.log(qf.connected(8, 9));
  }
}

class QuickFind {
  public nodes: number[]

  constructor(n: number) {
    this.nodes = [];
    for (let i = 0; i < n; i++) {
      this.nodes[i] = i;
    }    
  }

  public connected(n: number, m: number): boolean {
    return this.nodes[n] === this.nodes[m];
  }

  public union(n: number, m: number): void {
    if (this.connected(n, m)) {
      return;
    }

    var nId = this.nodes[n]
    var mId = this.nodes[m]
    for (let i = 0; i < this.nodes.length; i++) {
      if (this.nodes[i] === nId) {
        this.nodes[i] = mId;
      }
    }
  }
}

QuickFindAlg.main();