/**
 * 
 */
class LinkedListStackAlg {
  public static void main(String[] args) {
    LinkedListStack s = new LinkedListStack();
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

class LinkedListStack {
  private Node first = null;

  private class Node {
    String item;
    Node next;

    public String toString() {
      return item;
    }
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void push(String item) {
    Node newNode = new Node();
    newNode.item = item;
    newNode.next = first;
    first = newNode;
  }

  public String pop() {
    String item = first.item;
    first = first.next;
    return item;
  }
}