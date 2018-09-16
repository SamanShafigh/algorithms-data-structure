public class GenericStackAlg {
  public static void main(String[] args) {
    GenericStack s = new GenericStack<String>();
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

    // Autoboxing
    // For primitive types we need to have a wrapper object.
    // Each primitive types has a wrapper, for example Integre is
    // a wrapper type for int
    GenericStack<Integer> sn = new GenericStack<Integer>();
    sn.push(1);
    sn.push(2);
    sn.push(3);
    System.out.println(sn.pop());
    System.out.println(sn.pop());
    System.out.println(sn.pop());
    // This wrapper is a syntactic qugar. so behinde the scenes 
    // of casting we have this
    // GenericStack<Integer> sn = new GenericStack<Integer>();
    // sn.push(1);             // s.push(new Integer(1));
    // int a = sn.pop();       // int a = sn.pop().intValue();
  }
}

class GenericStack<Item> {
  private Node first = null;

  private class Node {
    Item item;
    Node next;

    public String toString() {
      return (String) item;
    }
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void push(Item item) {
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = first;
    first = newNode;
  }

  public Item pop() {
    Item item = first.item;
    first = first.next;
    
    return item;
  }
}