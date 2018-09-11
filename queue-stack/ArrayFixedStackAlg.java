/**
 * 
 */
public class ArrayFixedStackAlg {
  public static void main(String[] args) {
    ArrayFixedStack s = new ArrayFixedStack(5);
    s.push("a");
    s.push("b");
    s.push("c");
    s.push("d");
    
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
    return s[--n];
  }
}