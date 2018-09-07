/**
 * Optimized Quick-union by checking the size of each tree before connecting them 
 * together. The goal is to always add the small tree as a child of large tree. 
 * This strategy insures that the final tree is more flat compare to non optimized 
 * version of this algorithem.
 */
class QuickUnionAlg {
  public static main(): void {
    
    const qu = new QuickUnion(10);
    qu.union(2, 3);
    qu.union(4, 5);
    qu.union(1, 3);
    qu.union(7, 6);
    
    console.log(String(qu));
  }
}

class QuickUnion {
  public nodes: number[]
  public weight: number[]

  constructor(size: number) {
    this.nodes = new Array(size);
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

  public toString() {
    var content: String = "";
    for (let i = 0; i < this.nodes.length; i++) {
      content = content + `node ${i} is connected to ${this.nodes[i]} \n`;
    }

    return content;
  }
}

QuickUnionAlg.main();