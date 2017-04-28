package DoublyLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ZweNaing on 4/28/17.
 */
public class MyLinkedListTest {

  private static final int LONG_LIST_LENGTH = 10;

  MyLinkedList<String> shortList;
  MyLinkedList<Integer> emptyList;
  MyLinkedList<Integer> longerList;
  MyLinkedList<Integer> list1;

  /**
   * @throws java.lang.Exception
   */

  @Before
  public void setUp() throws Exception {
    // Feel free to use these lists, or add your own
    shortList = new MyLinkedList<String>();
    shortList.add("A");
    shortList.add("B");
    emptyList = new MyLinkedList<Integer>();
    longerList = new MyLinkedList<Integer>();
    for (int i = 0; i < LONG_LIST_LENGTH; i++) {
      longerList.add(i);
    }
    list1 = new MyLinkedList<Integer>();
    list1.add(65);
    list1.add(21);
    list1.add(42);
  }

  /**
   * Test if the get method is working correctly.
   */
  /*You should not need to add much to this method.
   * We provide it as an example of a thorough test. */
  @Test
  public void testGet() {
    //test empty list, get should throw an exception
    try {
      emptyList.get(0);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    // test short list, first contents, then out of bounds
    assertEquals("Check first", "A", shortList.get(0));
    assertEquals("Check second", "B", shortList.get(1));

    try {
      shortList.get(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
    try {
      shortList.get(2);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
    // test longer list contents
    for (int i = 0; i < LONG_LIST_LENGTH; i++) {
      assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
    }

    // test off the end of the longer array
    try {
      longerList.get(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
    try {
      longerList.get(LONG_LIST_LENGTH);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {
    }
  }

  /**
   * Test adding an element into the end of the list, specifically
   * public boolean add(E element)
   */
  @Test
  public void testAddEnd() {
    shortList.add("C");
    assertEquals(3, shortList.size());
    assertEquals("C", shortList.get(2));

    shortList.add("D");
    assertEquals(4, shortList.size());
    assertEquals("D", shortList.get(3));
  }

  /**
   * Test adding an element into the list at a specified index,
   * specifically:
   * public void add(int index, E element)
   */
  @Test
  public void testAddAtIndex() {
    shortList.add(1, "C");
    assertEquals(3, shortList.size());
    assertEquals("C", shortList.get(1));

    shortList.add(2, "D");
    assertEquals(4, shortList.size());
    assertEquals("D", shortList.get(2));

    try {
      shortList.add(5, "E");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.add(-1, "O");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
  }

  /**
   * Test removing an element from the list.
   * We've included the example from the concept challenge.
   * You will want to add more tests.
   */
  @Test
  public void testRemove() {
    int a = list1.remove(0);
    assertEquals("Remove: check a is correct ", 65, a);
    assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
    assertEquals("Remove: check size is correct ", 2, list1.size());

    String b = shortList.remove(1);
    assertEquals("Remove: check b is correct", "B", b);
    assertEquals("Remove: check element 0 is correct", "A", shortList.get(0));
    assertEquals("Remove: check size is correct ", 1, shortList.size());

    try {
      shortList.remove(2);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.remove(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
  }

  /**
   * Test the size of the list
   */
  @Test
  public void testSize() {
    assertEquals(2, shortList.size());
    assertEquals(0, emptyList.size());
    assertEquals(10, longerList.size());
    assertEquals(3, list1.size());
  }


  /**
   * Test setting an element in the list
   */
  @Test
  public void testSet() {

    assertEquals("B", shortList.set(1, "C"));
    assertEquals("C", shortList.get(1));
    assertEquals(2, shortList.size());

    assertEquals("A", shortList.set(0, "E"));
    assertEquals("E", shortList.get(0));
    assertEquals(2, shortList.size());

    try {
      shortList.set(-1, "F");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.set(2, "B");
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

  }

  /**
   * Test the exception cases
   */
  @Test
  public void testTestInput() {
    try {
      shortList.testIndex(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.testIndex(5);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.testInput(null);
      fail("Input data can't be null");
    } catch (NullPointerException e) {

    }
  }

}