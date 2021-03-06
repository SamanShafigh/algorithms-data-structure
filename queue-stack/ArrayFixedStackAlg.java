public class ArrayFixedStackAlg {
  public static void main(String[] args) {
    ArrayFixedStack s = new ArrayFixedStack(5);
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

class ArrayFixedStack {
  private String[] s;
  private int n = 0;

  public ArrayFixedStack(int capacity) {
    s = new String[capacity];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public void push(String item) {
    s[n++] = item;
  }

  public String pop() {
    String item = s[--n];
    // To avoid loitering since garbage collector can 
    // reclaim memory only if no outstanding refrences
    s[n] = null;
    return item;
  }
}