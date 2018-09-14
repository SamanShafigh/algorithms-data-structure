class LinkedListQueueAlg {
  public static main(): void {
    var lq: LinkedListQueue = new LinkedListQueue();
    lq.enqueue("a");
    lq.enqueue("b");
    lq.enqueue("c");
    console.log(lq.dequeue());

    lq.enqueue("d");
    console.log(lq.dequeue());
    
    console.log(lq.dequeue());
    console.log(lq.dequeue());
  }
}

class _Node {
  public item: string;
  public next: _Node;

  public toString(): string {
    return this.item;
  }
}

class LinkedListQueue {
  private first: _Node = null;
  private last: _Node = null;

  public isEmpty(): boolean {
    return this.first == null;
  }

  public enqueue(item: string): void {
    var previousLast: _Node = this.last;
    this.last = new _Node();
    this.last.item = item;
    this.last.next = null;

    if (this.isEmpty()) {
      this.first = this.last;
    } else {
      previousLast.next = this.last;
    }
  }

  public dequeue(): string {
    var item: string = this.first.item;
    this.first = this.first.next;
    if (this.isEmpty()) {
      this.last = null;
    }

    return item;
  }
}

LinkedListQueueAlg.main();