package DoublyLinkedList;

/**
 * Created by ZweNaing on 4/27/17.
 */
public class ListNode<E> {

  ListNode<E> next; // recursive (self-referencial) data type
  ListNode<E> prev; // recursive (self-referencial) data type
  E data;

  public ListNode() {
    this.next = null; // can be done automatically
    this.prev = null; // can be done automatically
    this.data = null;
  }

  public ListNode(E data) { // Don't need to add <T> in the constructor
    this.data = data;
  }

  public boolean equals(ListNode<E> n) {
    return this.data.equals(n.data);
  }

}
