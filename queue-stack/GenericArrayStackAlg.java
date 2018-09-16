public class GenericArrayStackAlg {
  public static void main(String[] args) {
    GenericArrayStack s = new GenericArrayStack<String>(5);
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

class GenericArrayStack<Item> {
  private Item[] s;
  private int n = 0;

  public GenericArrayStack(int capacity) {
    // Unfortunately we need to do this ugly type casting
    // since in Java we can not make generic array: `new Item[capacity]`
    s = (Item[]) new Object[capacity];
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public void push(Item item) {
    s[n++] = item;
  }

  public Item pop() {
    Item item = s[--n];
    // To avoid loitering since garbage collector can 
    // reclaim memory only if no outstanding refrences
    s[n] = null;
    return item;
  }
}