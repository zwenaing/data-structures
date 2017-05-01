package BinaryTree;

/**
 * Created by ZweNaing on 4/29/17.
 */
public class TreeNode<E extends Comparable<E>> {
  private TreeNode<E> parent;
  private TreeNode<E> left;
  private TreeNode<E> right;
  private E data;

  public TreeNode(E data) {
    this.data = data;
    this.parent = null;
    this.left = null;
    this.right = null;
  }

  /**
   *
   * @return the left node
   */
  public TreeNode<E> getLeft() {
    return left;
  }

  /**
   *
   * @param left node to set
   */
  public void setLeft(TreeNode<E> left) {
    this.left = left;
  }

  /**
   *
   * @return the right node
   */
  public TreeNode<E> getRight() {
    return right;
  }

  /**
   *
   * @param right node to set
   */
  public void setRight(TreeNode<E> right) {
    this.right = right;
  }

  /**
   *
   * @return the parent node
   */
  public TreeNode<E> getParent() {
    return parent;
  }

  /**
   *
   * @param parent node to set
   */
  public void setParent(TreeNode<E> parent) {
    this.parent = parent;
  }

  /**
   *
   * @param data to set
   */
  public void setData(E data) {
    this.data = data;
  }

  /**
   *
   * @return data of the node
   */
  public E getData() {
    return data;
  }

  /**
   * Check if the given value is present in the tree
   * @param toFind the value to find in the tree
   * @return true if found, otherwise false
   */
  public boolean containsNode(E toFind) {
    TreeNode<E> curr = this;
    while (curr != null) {
      int comp = toFind.compareTo(curr.data);
      if (comp > 0) {
        curr = curr.getRight();
      } else if (comp < 0) {
        curr = curr.getLeft();
      } else {
        return true;
      }
    }
    return false;
  }

  /**
   * Inserting a node of the given value
   * 1. Find the correct place to insert the new value
   *  i.    If the given value is smaller than current node, go left
   *  ii.   If the given value is larger than current node, go right
   *  iii.  If the node already exists in the tree, return false
   * 2. Insert the new node
   *  i. If the left or right node is null, insert the new node at that place
   * @param data
   * @return true if the a node is removed, false if there is no node with the value found
   */
  public boolean insertNode(E data) {
    TreeNode<E> newNode = new TreeNode<E>(data);

    int comp = data.compareTo(this.data);
    if (comp == 0) {
      return false;
    } else if (comp > 0) {
      if (this.right == null) {
        this.right = newNode;
        newNode.parent = this;
        return true;
      } else {
        this.right.insertNode(data);
      }
    } else {
      if (this.left == null) {
        this.left = newNode;
        newNode.parent = this;
        return true;
      } else {
        this.left.insertNode(data);
      }
    }
    return false;
  }

  /**
   * Deleting a node of the given value
   * 1. Find the node with the corresponding value
   * 2. Remove the discovered node
   *  i. If there are two children nodes
   *    a. Find the min value in the right tree
   *    b. Replace the min value in the current node
   *    c. Remove the min value in the right tree
   *  ii. If there are one left or right node
   *    a. If there is no left node, assign right node to the left of current node
   *    b. If there is no right node, assign left node to the right of current node
   *  iii. If there is no child node, replace it with null
   * @param value
   * @return true if the a node is removed, false if there is no node with the value found
   */
  public boolean deleteNode(E value) {
    int comp = value.compareTo(this.data);
    if (comp < 0) {
      if (this.left != null) {
        this.left.deleteNode(value);
      } else {
        return false;
      }
    } else if (comp > 0) {
      if (this.right != null) {
        this.right.deleteNode(value);
      } else {
        return false;
      }
    } else {
      if (this.left != null && this.right != null) {
        this.data = this.right.minValue();
        this.right.deleteNode(this.data);
        return true;
      } else if (this.parent.left == this) {
        this.parent.left = (this.left != null) ? this.left : this.right;
      } else {
        this.parent.right = (this.right != null) ? this.right : this.left;
      }
      return true;
    }
    return false;
  }

  /**
   * Find the min value
   * @return the value at the leftmost node
   */
  public E minValue() {
    if (this.left == null) {
      return this.data;
    } else {
      return this.left.minValue();
    }
  }
}
