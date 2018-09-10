/**
 * 
 */
public class LinkedListQueueAlg {
  public static void main(String[] args) {
    LinkedListQueue q = new LinkedListQueue();
    q.push("a");
    q.push("b");
    q.push("c");
    q.push("d");
    
    System.out.println(q.pop());
    System.out.println(q.pop());
    System.out.println(q.pop());
    System.out.println(q.pop());
  }
}

class LinkedListQueue {
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