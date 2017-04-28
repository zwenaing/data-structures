package SinglyLinkedList;

/**
 * Created by ZweNaing on 4/28/17.
 */
public class MyLinkedList<E> {
  private ListNode<E> head; // sentinal
  private ListNode<E> tail; // sentinal
  private int size;

  public MyLinkedList() {
    this.size = 0;
    this.head = new ListNode<E>();
    this.head.setNext(tail);
  }

  /**
   * Get the data at the given index
   * @param index
   * @return the data
   * @throws IndexOutOfBoundsException if the given index is negative or beyond the size of the list
   */
  public E get(int index) {
    this.checkEmpty();
    this.checkIndex(index);

    ListNode<E> current = this.head;
    while (index >= 0) {
      current = current.getNext();
      index--;
    }

    return current.getData();
  }

  /**
   * Add a new node right after head node
   * @param data
   * @throws NullPointerException if the given value is null
   */
  public void add(E data) {
    this.checkData(data);
    ListNode<E> newNode = new ListNode<E>(data);
    newNode.setNext(head.getNext());
    head.setNext(newNode);
    this.size++;
  }

  /**
   * Add a node at the given index
   * @param index
   * @param data
   */
  public void add(int index, E data) {
    this.checkIndex(index);
    this.checkData(data);

    ListNode<E> current = head;
    while (index > 0) {
      current = current.getNext();
      index--;
    }

    ListNode<E> nextNode = current.getNext();
    ListNode<E> newNode = new ListNode<E>(data);
    current.setNext(newNode);
    newNode.setNext(nextNode);
    this.size++;
  }

  /**
   * Remove the node at the given index
   * @param index
   * @return the data at the given node
   */
  public E remove(int index) {
    this.checkEmpty();
    this.checkIndex(index);

    ListNode<E> current = head;
    while (index > 0) {
      current = current.getNext();
      index--;
    }

    ListNode<E> toBeReomvedNode = current.getNext();
    ListNode<E> afterRemovedNode = toBeReomvedNode.getNext();
    current.setNext(afterRemovedNode);

    this.size--;

    return toBeReomvedNode.getData();

  }

  /**
   * Set the data of the given index to the given value
   * @param index of the node of which value to be replaced
   * @param data to be used to replace
   * @return the original value
   */
  public E set(int index, E data) {
    this.checkEmpty();
    this.checkIndex(index);
    this.checkData(data);

    ListNode<E> current = head;
    while (index >= 0) {
      current = current.getNext();
      index--;
    }
    E originalValue = current.getData();
    current.setData(data);

    return originalValue;
  }

  /**
   * Getter for size
   * @return the size of this list
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Check whether the given data is null
   * @param data
   * @throws NullPointerException if the given data is null
   */
  public void checkData(E data) {
    if (data == null) {
      throw new NullPointerException();
    }
  }

  /**
   * Check whether the given index is negative or beyond the size of the list
   * @param index
   * @throws IndexOutOfBoundsException if the condition is not met
   */
  public void checkIndex(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Check whether this is an empty list
   */
  public void checkEmpty() {
    if (this.size == 0) {
      throw new NullPointerException();
    }
  }

}
