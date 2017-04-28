package DoublyLinkedList;

/**
 * Created by ZweNaing on 4/27/17.
 */
public class MyLinkedList<E> {

  private ListNode<E> head;
  private ListNode<E> tail;
  private int size;

  public MyLinkedList() {
    this.head = new ListNode<E>();
    this.tail = new ListNode<E>();
    head.next = tail;
    tail.prev = head;
    this.size = 0;
  }

  /**
   * Appends an element to the end of the list
   *
   * @param element The element to add
   */
  public boolean add(E element) {
    this.testInput(element);

    ListNode<E> newNode = new ListNode<E>(element);
    tail.prev.next = newNode;
    newNode.prev = tail.prev;
    newNode.next = tail;
    tail.prev = newNode;
    this.size++;

    return false;
  }

  /**
   * Get the element at position index
   *
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  public E get(int index) {

    this.testIndex(index);

    ListNode<E> current = head;

    while (index >= 0) {
      current = current.next;
      index--;
    }

    return current.data;
  }

  /**
   * Add an element to the list at the specified index
   *
   * @param index where the element should be added
   * @param element The element to add
   */
  public void add(int index, E element) {

    this.testIndex(index);
    this.testInput(element);

    ListNode<E> current = head;

    while (index >= 0) {
      current = current.next;
      index--;
    }

    ListNode<E> previousNode = current.prev;
    ListNode<E> newNode = new ListNode<E>(element);
    previousNode.next = newNode;
    newNode.next = current;
    current.prev = newNode;
    this.size++;
  }


  /**
   * Return the size of the list
   */
  public int size() {
    return this.size;
  }

  /**
   * Remove a node at the specified index and return its data element.
   *
   * @param index The index of the element to remove
   * @return The data element removed
   * @throws IndexOutOfBoundsException If index is outside the bounds of the list
   */
  public E remove(int index) {

    this.testIndex(index);

    ListNode<E> current = head;

    while (index >= 0) {
      current = current.next;
      index--;
    }

    ListNode<E> previousNode = current.prev;
    ListNode<E> nextNode = current.next;

    previousNode.next = nextNode;
    nextNode.prev = previousNode;

    this.size--;

    return current.data;
  }

  /**
   * Set an index position in the list to a new element
   *
   * @param index The index of the element to change
   * @param element The new element
   * @return The element that was replaced
   * @throws IndexOutOfBoundsException if the index is out of bounds.
   */
  public E set(int index, E element) {

    this.testIndex(index);
    this.testInput(element);

    ListNode<E> current = head;

    while (index >= 0) {
      current = current.next;
      index--;
    }

    E currentData = current.data;
    current.data = element;

    return currentData;
  }

  /**
   * Check whether the given index is valid
   *
   * @throws IndexOutOfBoundsException if the index is negative or beyond the size of the list
   */
  public void testIndex(int index) {
    if (index < 0 || index >= this.size) {
      throw new IndexOutOfBoundsException();
    }
  }

  /**
   * Check the given input is valid
   *
   * @throws NullPointerException if the given data is NULL
   */
  public void testInput(E data) {
    if (data == null) {
      throw new NullPointerException();
    }
  }
}
