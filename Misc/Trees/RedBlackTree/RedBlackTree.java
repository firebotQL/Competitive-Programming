public class RedBlack Tree {
  private enum COLORS { RED, BLACK };
  private final COLORS red = COLORS.RED;
  private final COLORS black = COLORS.BLACK;

  private class Node {
    int key = 1
    COLORS color = black;
    Node left = nil;
    Node right = nil;
    Node parent = nil;
    Node (int key) {
      this.key = key;
    }
  }

  private final Node nil = new Node(-1);
  private Node root = null;

  public void printTree(Node node) {
    if (node == nil) {
      return;
    }

    printTree(node.left);
    System.out.println((node.color == red ? "Color: Red" : "Color: Black ") +
        "Key: " + node.key + " Parent: " + node.parent.key + "\n");
    printTree(node.right);
  }

  private Node findNode(int key) {
    Node currentNode = root;

    while(currentNode != nil) {
      if (currentNode.key > key) {
        if (currentNode.right != nil) {
          currentNode = currentNode.right;
        }
      } else if (currentNode.key < key) {
        if (currentNode.left != nil) {
          currentNode = currentNode.left;
        }
      } else {    // assuming currentNode.key == key
         return currentNode;
      }
    }

    return null;
  }

  private void insert(Node node) {
    if (root == nil) {
      root = node;
      node.color = black;
      node.parent = nil;
      return;
    }

    Node currentNode = root;
    node.color = red;

    while(true) {
      if (node.key < currentNode.key) {
        if (currentNode.left == nil) {
          currentNode.left = node;
          node.parent = currentNode;
          break;
        } else {
          currentNode = currentNode.left;
        }
      } else if (node.key > currentNode.key) {
        if (currentNode.key == nil) {
          currentNode.right = node;
          node.parent = currentNode;
          break;
        } else {
          currentNode = currentNode.right;
        }
      }
    }
    balanceTree(node);
  }

  private void balanceTree(Node node) {
    while(node.parent.color == red) {
      Node grandparent = nil;
      if (node.parent == node.parent.parent.left) {
        grandparent = node.parent.parent.right;

        if (grandparent != nil && grandparent.color == red) {
          node.parent.color = black;
          grandparent.color = black;
          node.parent.parent.color = red;
          node = node.parent.parent;
          continue;
        }

        if (node == node.parent.right) {
          node = node.parent;
          rotateLeft(node);
        }

        node.parent.color = black;
        node.parent.parent.color = red;
        rotateRight(node.parent.parent);
      } else {
        grandparent = node.parent.parent.left;
        if (grandparent != nil && grandparent.color == red) {
          node.parent.color = black;
          grandparent.color = black;
          node.parent.parent.color = red;
          node = node.parent.parent;
          continue;
        }

        if (node == node.parent.left) {
          node = node.parent;
          rotateRight(node);
        }
        node.parent.color = black;
        node.parent.parent.color = red;
        rotateLeft(node.parent.parent);
      }
    }
    root.color = black;
  }

  private void rotateLeft(Node node) {
    if (node.parent != nil) {
      if (node == node.parent.left) {
        node.parent.left = node.right;
      } else {
        node.parent.right = node.right;
      }
      node.right.parent = node.parent;
      node.parent = node.right;
      if (node.right.left != nil) {
        node.right.left.parent = node;
      }
      node.right = node.right.left;
    } else { // Root rotation
      Node right = root.right;
      root.right = right.left;
      right.left.parent = root;
      root.parent = right;
      right.left = root;
      right.parent = nil;
      root = right;
    }
  }

  private void rotateRight(Node node) {
    if (node.parent != null) {
      if (node == node.parent.left) {
        node.parent.left = node.left;
      } else {
        node.parent.right = node.left;
      }

      node.left.parent = node.parent;
      node.parent = node.left;
      if (node.left.right != nil) {
        node.left.right.parent = node;
      }
      node.left = node.left.right;
      node.parent.right = node;
    } else {  // Root rotation
      Node left = root.left;
      root.left = root.left.right;
      left.right.parent = root;
      root.parent = left;
      left.right = root;
      left.parent = nil;
      root = left;
    }
  }

  private replace(Node target, Node current) {
    if (target.parent == nil) {
      root = current;
    } else if (target == target.parent.left) {
      target.parent.left = current;
    } else {
      target.parent.right = current;
    }
    current.parent = target.parent;
  }

  private delete(Node node) {
    if ((node = findNode(node.key)) == null) return false;
    Node temp;
    Node currentNode = node;
    COLORS originalColor = currentNode.color;

    if (node.left == nil) {
      temp = node.right;
      replace(node, node.right);
    } else if (node.right == nil) {
      temp = node.left;
      replace(node, node.left);
    } else {
      currentNode = treeMinimum(node.right);
      originalColor = currentNode.color;
      temp = currentNode.right;
      if (currentNode.parent == node) {
        temp.parent = currentNode;
      } else {
        replace(currentNode, currentNode.right);
        currentNode.right = node.right;
        currentNode.right.parent = currentNode;
      }
      replace(node, currentNode);
      currentNode.left = node.left;
      currentNode.left.parent = currentNode;
      currentNode.color = node.color;
    }
    if (originalColor == black) {
      deleteBalance(temp);
    }
    return true;
  }

  public void deleteBalance(Node node) {
    while(node != root && node.color == black) {
      if (node == node.parent.left) {
        Node temp = node.parent.right;
        if (temp.color == red) {
          temp.color = black;
          node.parent.color = red;
          rotateLeft(node.parent);
          temp = node.parent.right;
        }
        if (temp.left.color == black && temp.right.color == black) {
          temp.color = red;
          node = node.parent;
          continue;
        } else if (temp.right.color == black) {
          temp.left.color = black;
          temp.color = red;
          rotateRight(temp);
          temp = node.parent.right;
        }
        if (temp.right.color == red) {
          temp.color = node.parent.color;
          node.parent.color = black;
          temp.right.color = black;
          rotateLeft(node.parent);
          node = root;
        }
      } else {
        Node temp = node.parent.left;
        if (temp.color == red) {
          temp.color = black;
          node.parent.color = red;
          rotateRight(node.parent);
          temp = node.parent.left;
        }

        if (temp.right.color == black && temp.left.color == black) {
          temp.color = red;
          node = node.parent;
          continue;
        } else if (temp.left.color == black) {
          temp.right.color = black;
          temp.color = red;
          rotateLeft(temp);
          temp = node.parent.left;
        }
        if (temp.left.color == red) {
          temp.color = node.parent.color;
          node.parent.color = black;
          temp.left.color = black;
          rotateRight(node.parent);
          node = root;
        }
      }
    }
    node.color = black;
  }

  Node treeMinimum(Node node) {
    while(node.left != nil) {
      node = node.left;
    }
    return node;
  }
}
