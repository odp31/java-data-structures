// self balancing binary search tree that has the following properties:
// node color - each node has a color, red or black
// root property- root node is always black
// leaf property- all leaves are black
// black height property - all paths from a node to any of its descendants leaves
// contains the same number of black nodes 

public class RedBlackTree
  {
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
      int key;
      boolean color;
      Node left, right, parent;
      Node(int key) {
        this.key = key;
        this.color = RED;
      }
    }
    private boolean isRed(Node x) {
      if (x == null)
        return false;
      return x.color == RED;
    }
    private Node rotateLeft(Node h) {
      Node x = h.right;
      h.right = x.left;
      x.left = h;
      x.color = h.color;
      h.color = RED;
      return x;
    }
    private Node rotateRight(Node h) {
      Node x = h.left;
      h.left = x.right;
      x.right = h;
      x.color = h.color;
      h.color = RED;
      return x;
    }
    private void flipColors(Node h) {
      h.color = !h.color;
      h.left.color = !h.left.color;
      h.right.color = !h.right.color;
    }
    private Node balance(Node h) {
      if(isRed(h.right) && !isRed(h.left))
        h = rotateLeft(h);
      if (isRed(h.left) && isRed(h.left.left))
        h = rotateRight(h);
      if (isRed(h.left) && isRed(h.right))
        flipColors(h);
      return h;
    }
    public void insert(int key) {
      root = insert(root, key);
      root.color = BLACK;
    }
    private Node insert(Node h, int key) {
      if(h == null)
        return new Node(key);
      if(key < h.key)
        h.left = insert(h.left, key);
      else if(key > h.key)
        h.right = insert(h.right, key);
      else
        return h;
      h = balance(h);
      return h;
    }
  }
