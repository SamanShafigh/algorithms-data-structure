class QuickFind {
  private nodes: number[]

  constructor() {
    this.nodes = [];
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