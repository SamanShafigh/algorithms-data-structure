class LinkedListStackAlg {
  public static main(): void {
    var s: LinkedListStack = new LinkedListStack();
    s.push("a");
    s.push("b");
    s.push("c");
    console.log(s.pop());

    s.push("d");
    console.log(s.pop());
    
    console.log(s.pop());
    console.log(s.pop());
  }
}

class _Node {
  public item: string;
  public next: _Node;

  public toString(): string {
    return this.item;
  }
}

class LinkedListStack {
  private first: _Node = null;

  public isEmpty(): boolean {
    return this.first == null;
  }

  public push(item: string): void {
    var newNode: _Node = new _Node();
    newNode.item = item;
    newNode.next = this.first;
    this.first = newNode;
  }

  public pop(): string {
    var item: string = this.first.item;
    this.first = this.first.next;

    return item;
  }
}

LinkedListStackAlg.main();