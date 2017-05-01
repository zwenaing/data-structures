package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ZweNaing on 4/29/17.
 */
public class BinaryTree<E extends Comparable<E>> {
  TreeNode<E> root;

  /**
   * Initialize the binary tree with the data at the root
   * @param data
   */
  public BinaryTree(E data) {
    this.root = new TreeNode<E>(data);
  }

  /**
   * To list the nodes in preOrder sequence
   * @param node
   */
  private void preOrder(TreeNode<E> node) {
    if (node != null) {
      System.out.println(node.getData());
      preOrder(node.getLeft());
      preOrder(node.getRight());
    }
  }

  public void preOrder() {
    this.preOrder(this.root);
  }

  /**
   * To list the nodes in postOrder sequence
   * @param node
   */
  private void postOrder(TreeNode<E> node) {
    if (node != null) {
      postOrder(node.getLeft());
      postOrder(node.getRight());
      System.out.println(node.getData());
    }
  }

  public void postOrder() {
    this.postOrder(this.root);
  }

  /**
   * To list the nodes in inOrder sequence
   * @param node
   */
  private void inOrder(TreeNode<E> node) {
    if (node != null) {
      inOrder(node.getLeft());
      System.out.println(node.getData());
      inOrder(node.getRight());
    }
  }

  public void inOrder() {
    this.inOrder(this.root);
  }

  /**
   * To list the nodes in levelOrder sequence
   * @param node
   */
  private void levelOrder(TreeNode<E> node) {
    Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
    q.add(node);
    while (!q.isEmpty()) {
      TreeNode<E> curr = q.remove();
      if (curr != null) {
        System.out.println(curr.getData());
        q.add(curr.getLeft());
        q.add(curr.getRight());
      }
    }
  }

  public void levelOrder() {
    this.levelOrder(this.root);
  }

  /**
   * Check if the given value is present in the tree
   * @param toFind the value to find in the tree
   * @return true if found, otherwise false
   */
  public boolean contains(E toFind) {
    return this.root.containsNode(toFind);
  }

  /**
   * Inserting a node of the given value
   * @param data
   * @return true if the a node is removed, false if there is no node with the value found
   */
  public boolean insert(E data) {
    return this.root.insertNode(data);
  }

  /**
   * Deleting a node of the given value
   * @param value
   * @return true if the a node is removed, false if there is no node with the value found
   */
  public boolean delete(E data) {
    return this.root.deleteNode(data);
  }
}
