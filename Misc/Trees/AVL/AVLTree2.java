import java.util.*;

/**
* AVL Tree algorithm implementation.
* Original source: www.ideserve.co.uk/learn/avl-tree-deletion
**/
public class AVLTree2 {

	private class QueueNode
    {
        Node treeNode;
        int level;
         
        QueueNode(Node treeNode, int level)
        {
            this.treeNode = treeNode;
            this.level = level;
        }
    }

	private class Node {
		int data;
		Node left;
		Node right;
		int height;
		Node(int data) {
			this.data = data;
			this.height = 1;
		}
	}

	Node root;

	public AVLTree2(int data) {
		root = new Node(data);
	}

	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}

	public void updateHeight(Node node) {
		if (node == null) {
			return;
		}

		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public Node rotateRight(Node node) {
		if (node == null) return node;

		Node beta = node.left;
		Node t2 = beta.right;

		beta.right = node;
		node.left = t2;

		// first need to update the height of node because heigh of beta uses heigt of node
		updateHeight(node);

		// now we update height of beta
		updateHeight(beta);

		return beta;
	} 

	public Node rotateLeft(Node node) {
		if (node == null) return node;

		Node beta = node.right;
		Node t2 = beta.left;

		beta.left = node;
		node.right = t2;

		updateHeight(node);

		updateHeight(node);

		return beta;
	}

	public int getBalance(Node node) {
		if (node == null) {
			return 0;
		}

		int balance = getHeight(node.left) - getHeight(node.right);

		return balance;
	}

	private int getMinValue(Node node) {
		if (node == null) return Integer.MIN_VALUE;

		if (node.left == null) return node.data;

		return getMinValue(node.left);
	}

	private Node delete(Node node, int key) {
		if (node == null) return null;

		if (key < node.data) {
			node.left = delete(node.left, key);
		} else if (key > node.data) {
			node.right = delete(node.right, key);
		} else {
			if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			} else {
				int inorderSuccessorValue = getMinValue(node.right);
				node.data = inorderSuccessorValue;
				node.right = delete(node.right, inorderSuccessorValue);
			}
		}

		if (node == null) {
			return null;
		}

		updateHeight(node);

		int balance = getBalance(node);

		if (balance > 1) {	// left-left || left-right
			if (getBalance(node.left) >= 0) { // left-left	
				node = rotateRight(node);
			} else {						  // left-right
				node.left = rotateLeft(node.left);
				node = rotateRight(node);
			}
		} else if (balance < -1) {	// right-right || right-left
			if (getBalance(node.right) <= 0) { 	// right-right
				node = rotateLeft(node);
			} else {							// right-left
				node.right = rotateRight(node.right);
				node = rotateLeft(node);
			}
		}

		return node;
	}

	private Node insert(Node node, int key) {
		if (node == null) return new Node(key);

		if (key < node.data) {
			node.left = insert(node.left, key);
		} else if (key > node.data) {
			node.right = insert(node.right, key);
		} else {
			return node;
		}

		updateHeight(node);

		int balance = getBalance(node);

		if (balance > 1) {
			if (key < node.left.data) {
				node = rotateRight(node);
			} else {
				node.left = rotateLeft(node.left);
				node = rotateRight(node);
			}
		} else if (balance < -1) {
			if (key > node.right.data) {
				node = rotateLeft(node);
			} else {
				node.right = rotateRight(node.right);
				node = rotateLeft(node);
			}
		}
		return node;
	}

	public void insert(int key) {
		root = insert(this.root, key);
	}

	public void delete(int key) {
		root = delete(this.root, key);
	}

	public void printTreeLevelOrder() {
		if (root == null) return;
		LinkedList queue = new LinkedList();
		queue.add(new QueueNode(root, 0));

		int maxLevelVisited = -1;
		while(!queue.isEmpty()) {
			QueueNode currentNode = (QueueNode) queue.remove();

			if (currentNode.level > maxLevelVisited) {
				maxLevelVisited = currentNode.level;
				System.out.println("\nlevel-" + currentNode.level + " nodes: ");
			}

			System.out.print(" " + currentNode.treeNode.data);

			if (currentNode.treeNode.left != null) {
				queue.add(new QueueNode(currentNode.treeNode.left, currentNode.level + 1));
			}

			if (currentNode.treeNode.right != null) {
				queue.add(new QueueNode(currentNode.treeNode.right, currentNode.level + 1));
			}
		}
	}

	public static void main(String[] args) {
		AVLTree2 tree = new AVLTree2(0);

		for(int i = 1; i < 6; i++) {
			tree.insert(i);
		}
		tree.printTreeLevelOrder();

		tree.delete(1);

		tree.printTreeLevelOrder();
	}
}