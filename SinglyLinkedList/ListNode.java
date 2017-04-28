package SinglyLinkedList;

/**
 * Created by ZweNaing on 4/28/17.
 */
public class ListNode<E> {

  private ListNode<E> next; // keeps the node that comes after this node
  private E data; // keeps the data inside

  /**
   * Constructor for the list with a given data
   */
  public ListNode(E data) {
    this.data = data;
    this.next = null;
  }

  /**
   * Constructor for the list with no given data
   */
  public ListNode() {
    this(null);
  }

  public ListNode<E> getNext() {
    return next;
  }

  public void setNext(ListNode<E> next) {
    this.next = next;
  }

  public E getData() {
    return data;
  }

  public void setData(E data) {
    this.data = data;
  }
}
