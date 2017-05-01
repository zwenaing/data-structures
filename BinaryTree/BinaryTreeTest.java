package BinaryTree;

import static org.junit.Assert.*;

import apple.laf.JRSUIUtils.Tree;
import java.util.LinkedList;
import java.util.Queue;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ZweNaing on 4/29/17.
 */
public class BinaryTreeTest {
  BinaryTree<Integer> intTree;
  BinaryTree<String> strTree;

  @Before
  public void setup() {
    strTree = new BinaryTree<String>("E");
    TreeNode<String> n1 = new TreeNode<String>("C");
    strTree.root.setLeft(n1);
    n1.setParent(strTree.root);
    TreeNode<String> n2 = new TreeNode<String>("G");
    strTree.root.setRight(n2);
    n2.setParent(strTree.root);
    TreeNode<String> n3 = new TreeNode<String>("A");
    n1.setLeft(n3);
    n3.setParent(n1);
    TreeNode<String> n4 = new TreeNode<String>("B");
    n1.setRight(n4);
    n4.setParent(n1);
    TreeNode<String> n5 = new TreeNode<String>("F");
    n2.setLeft(n5);
    n5.setParent(n2);
    TreeNode<String> n6 = new TreeNode<String>("I");
    n2.setRight(n6);
    n6.setParent(n2);
  }

  @Test
  public void testContains() {
    assertTrue(strTree.contains("A"));
    assertTrue(strTree.contains("G"));
    assertTrue(strTree.contains("I"));
    assertFalse(strTree.contains("Z"));
    assertFalse(strTree.contains("H"));
  }

  @Test
  public void testInsert() {
    intTree = new BinaryTree<Integer>(10);
    intTree.insert(6);
    intTree.insert(12);
    assertEquals(10, (int)intTree.root.getData());
    assertEquals(12, (int)intTree.root.getRight().getData());
    assertEquals(6, (int)intTree.root.getLeft().getData());
  }

  @Test
  public void testDelete() {
    assertEquals("A", strTree.root.getLeft().getLeft().getData());
    strTree.delete("A");
    assertNull(strTree.root.getLeft().getLeft());
    assertEquals("G", strTree.root.getRight().getData());
    strTree.delete("G");
    assertEquals("I", strTree.root.getRight().getData());
    assertNull(strTree.root.getRight().getRight());
    assertEquals("F", strTree.root.getRight().getLeft().getData());
    assertEquals("E", strTree.root.getData());
    strTree.delete("E");
    assertEquals("F", strTree.root.getData());
    assertEquals("I", strTree.root.getRight().getData());
    assertNull(strTree.root.getRight().getLeft());
  }
}