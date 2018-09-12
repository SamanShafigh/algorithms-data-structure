class ArrayFixedStackAlg {
  public static main(): void {
    const s: ArrayFixedStack = new ArrayFixedStack(5);
    s.push("a");
    s.push("b");
    s.push("c");
    s.push("d");
    s.push("e");
    console.log(s.pop());

    s.push("f");
    console.log(s.pop());

    console.log(s.pop());
    console.log(s.pop());
    console.log(s.pop());
  }
}

class ArrayFixedStack {
  private s: string[];
  private n: number = 0;

  constructor(capacity: number) {
    this.s = new Array(capacity);
  }

  public isEmpty(): boolean {
    return this.n == null;
  }

  public push(item: string): void {
    this.s[this.n++] = item;
  }

  public pop(): string {
    return this.s[--this.n];
  }
}


ArrayFixedStackAlg.main();