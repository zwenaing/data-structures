package SinglyLinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ZweNaing on 4/28/17.
 */
public class MyLinkedListTest {
  MyLinkedList<Integer> emptyList;
  MyLinkedList<String> shortList;

  /**
   * Setting up one empty list and a linked list consisting of three elements
   */
  @Before
  public void setup() {
    emptyList = new MyLinkedList<Integer>();
    shortList = new MyLinkedList<String>();
    shortList.add("A");
    shortList.add("B");
    shortList.add("C");
  }

  /**
   * Test the exception on getting appropriate index
   */
  @Test
  public void testCheckIndex() {
    try {
      shortList.checkIndex(-1);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.checkIndex(10);
      fail("Check out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
  }

  /**
   * Test the exception on checking given data
   */
  @Test
  public void testCheckData() {
    try {
      shortList.checkData(null);
      fail("Null is not accepted");
    } catch (NullPointerException e) {

    }
  }

  /**
   * Test adding a new element into the list
   */
  @Test
  public void testAdd() {
    emptyList.add(1);
    assertEquals(1, emptyList.getSize());
    assertEquals(1, (int) emptyList.get(0));

    emptyList.add(2);
    assertEquals(2, emptyList.getSize());
    assertEquals(1, (int) emptyList.get(1));
  }

  /**
   * Test getting an element at the given index
   */
  @Test
  public void testGet() {
    assertEquals("C", shortList.get(0));
    assertEquals("B", shortList.get(1));
    assertEquals("A", shortList.get(2));

    try {
      emptyList.get(0);
      fail("This is an empty list");
    } catch (NullPointerException e) {

    }

    try {
      shortList.get(-1);
      fail("Index out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.get(5);
      fail("Index out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }
  }

  /**
   * Test adding a new element at the given index
   */
  @Test
  public void testAddAtIndex() {
    shortList.add(1, "D");
    assertEquals(4, shortList.getSize());
    assertEquals("D", shortList.get(1));
    assertEquals("B", shortList.get(2));
    assertEquals("C", shortList.get(0));

    shortList.add(3, "E");
    assertEquals(5, shortList.getSize());
    assertEquals("E", shortList.get(3));
    assertEquals("A", shortList.get(4));
    assertEquals("B", shortList.get(2));

    try {
      shortList.add(-1, "F");
      fail("Index out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.add(10, "G");
      fail("Index out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.add(3, null);
      fail("Null is not accepted");
    } catch (NullPointerException e) {

    }
  }

  /**
   * Test removing the element at the given index
   */
  @Test
  public void testRemove() {
    try {
      emptyList.remove(0);
      fail("The list is an empty list");
    } catch (NullPointerException e) {

    }

    try {
      shortList.remove(-1);
      fail("Array out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.remove(10);
      fail("Array out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    String c = shortList.remove(0);
    assertEquals("C", c);
    assertEquals("B", shortList.get(0));
    assertEquals("A", shortList.get(1));
    assertEquals(2, shortList.getSize());

    String a = shortList.remove(1);
    assertEquals("A", a);
    assertEquals("B", shortList.get(0));
    assertEquals(1, shortList.getSize());
  }

  /**
   * Test setting the element at the given index with new data
   */
  @Test
  public void testSet() {
    try {
      emptyList.set(0, 10);
      fail("The list is an empty list");
    } catch (NullPointerException e) {

    }

    try {
      shortList.set(-1, "C");
      fail("Array out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    try {
      shortList.set(10, "F");
      fail("Array out of bounds");
    } catch (IndexOutOfBoundsException e) {

    }

    String a = shortList.set(2, "D");
    assertEquals(a, "A");
    assertEquals("D", shortList.get(2));
    assertEquals(3, shortList.getSize());

    String c = shortList.set(0, "F");
    assertEquals(c, "C");
    assertEquals("F", shortList.get(0));
    assertEquals(3, shortList.getSize());
  }
}