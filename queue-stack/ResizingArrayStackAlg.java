public class ResizingArrayStackAlg {
  public static void main(String[] args) {
    ResizingArrayStack s = new ResizingArrayStack(5);
    s.push("a");
    s.push("b");
    s.push("c");
    s.push("d");
    s.push("e");
    System.out.println(s.pop());

    s.push("f");
    System.out.println(s.pop());

    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.pop());
  }
}

class ResizingArrayStack {
  private String[] s;
  private int n = 0;

  public ResizingArrayStack(int capacity) {
    s = new String[capacity];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public void push(String item) {
    if (n == s.length) resize(2 * n);
    s[n++] = item;
  }

  public String pop() {
    String item = s[--n];
    // To avoid loitering since garbage collector can 
    // reclaim memory only if no outstanding refrences
    s[n] = null;
    return item;
  }

  private void resize(int capacity) {
    String[] copy = new String[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = s[i];
    }
    s = copy;
  }
}