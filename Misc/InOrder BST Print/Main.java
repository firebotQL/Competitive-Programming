import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Node<Character> head = getBST();
        for(Character ch : getInOrderResult(head)) {
            System.out.print(ch + " ");
        }
    }

    public static List<Character> getInOrderResult(Node<Character> head) {
        Stack<Node<Character>> stack = new Stack<Node<Character>>();
        List<Character> resultList = new ArrayList<Character>();
        Node<Character> node = head;
        while(node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.getLeft();
            } else if (stack.size() > 0) {
                node = stack.pop();
                resultList.add(node.getKey());
                node = node.getRight();
            }
        }
        return resultList;
    }

    // let BST be char
    public static Node<Character> getBST() {
        Node<Character> head = new Node<Character>('F');
        Node<Character> leftLevelOne = new Node<Character>('B');
        Node<Character> rightLevelOne = new Node<Character>('G');
        head.setLeft(leftLevelOne);
        head.setRight(rightLevelOne);
        Node<Character> leftLeftLevelTwo = new Node<Character>('A');
        Node<Character> leftRightLevelTwo = new Node<Character>('D');
        leftLevelOne.setLeft(leftLeftLevelTwo);
        leftLevelOne.setRight(leftRightLevelTwo);
        Node<Character> rightRightLevelTwo = new Node<Character>('I');
        rightLevelOne.setRight(rightRightLevelTwo);
        Node<Character> leftLeftLevelThree = new Node<Character>('C');
        Node<Character> leftRightLevelThree = new Node<Character>('E');
        leftRightLevelTwo.setLeft(leftLeftLevelThree);
        leftRightLevelTwo.setRight(leftRightLevelThree);
        Node<Character> rightLeftLevelThree = new Node<Character>('H');
        rightRightLevelTwo.setLeft(rightLeftLevelThree);
        return head;
    }

    public static class Node<T> {
        private Node<T> left = null;
        private Node<T> right = null;
        private T key;

        public Node(T key) {
            this.key = key;
        }
        public Node<T> getLeft() {
            return left;
        }
        public Node<T> getRight() {
            return right;
        }
        public void setLeft(Node<T> left) {
            this.left = left;
        }
        public void setRight(Node<T> right) {
            this.right = right;
        }
        public T getKey() {
            return key;
        }
    }
}