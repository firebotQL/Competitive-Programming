/**
* 4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer
* elements, write an algorithm to create a binary search tree with minimal
* height.
*/
import java.util.*;

public class Main {

  public static class Node {
    int key;
    Node left, right;
    public Node(int key) {
      this.key = key;
    }
  }

  public static void main(String[] args) {
      int[] array = { 1, 2, 3, 4, 5, 6 };
      Node root = buildMinimalBST(array, 0, array.length - 1);
      printByLevel(root);
  }

  public static Node buildMinimalBST(int[] array, int start, int end) {
    if (end < start) return null;

    int mid = (start + end)/2;
    Node node = new Node(array[mid]);
    node.left = buildMinimalBST(array, start, mid - 1);
    node.right = buildMinimalBST(array, mid + 1, end);
    return node;
  }

  public static void printByLevel(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    Queue<Node> queue2 = new LinkedList<Node>();
    queue.offer(node);
    int level = 1;
    while(!queue.isEmpty()) {
      System.out.println("Level " + level++ + " keys: ");
      while(!queue.isEmpty()) {
        Node current = queue.poll();
        System.out.print(" " + current.key);
        if (current.left != null) {
          queue2.offer(current.left);
        }
        if (current.right != null) {
          queue2.offer(current.right);
        }
      }
      System.out.println();
      Queue<Node> tmp = queue;
      queue = queue2;
      queue2 = tmp;
    }
  }

}
