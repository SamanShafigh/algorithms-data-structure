public class LinkedListQueueAlg {
  public static void main(String[] args) {
    LinkedListQueue lq = new LinkedListQueue();
    lq.enqueue("a");
    lq.enqueue("b");
    lq.enqueue("c");
    System.out.println(lq.dequeue());

    lq.enqueue("d");
    System.out.println(lq.dequeue());
    
    System.out.println(lq.dequeue());
    System.out.println(lq.dequeue());
  }
}

class LinkedListQueue {
  private Node first, last;

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

  public void enqueue(String item) {
    Node previousLast = last;
    last = new Node();
    last.item = item;
    last.next = null;

    // Handle epmty queue
    if (isEmpty()) {
      first = last;
    } else {
      previousLast.next = last;
    }
  }

  public String dequeue() {
    String item = first.item;
    first = first.next;
    // Handle epmty queue
    if (isEmpty()) last = null;
    
    return item;
  }
}