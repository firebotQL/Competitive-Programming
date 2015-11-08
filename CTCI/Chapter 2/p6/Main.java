import java.io.IOException;
import java.util.Stack;

/**
 * 2.6 Palindrome - Implement a function to check if a linked list is a palindrome.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String palindrome = "ATOYOTA";
        String notPalindrome = "MOCROM";
        System.out.println(palindrome + " is palindrome? " + isPalindrome(palindrome.toCharArray()));
        System.out.println(notPalindrome + " is palindrome? " + isPalindrome(notPalindrome.toCharArray()));
    }

    private static boolean isPalindrome(char[] array) {
        Node<Character> head = generateList(array);
        Node<Character> slowNode = head;
        Node<Character> fastNode = head;
        Stack<Character> stack = new Stack<Character>();
        while(slowNode != null && fastNode != null && fastNode.getNext() != null) {
            stack.push(slowNode.getValue());
            slowNode = slowNode.getNext();
            fastNode = fastNode.getNext().getNext();
        }

        if (fastNode != null) {
            slowNode = slowNode.getNext();
        }

        while(slowNode != null) {
            if (slowNode.getValue().compareTo(stack.pop()) == 0) {
                slowNode = slowNode.getNext();
            } else {
                return false;
            }
        }

        return true;
    }


    public static Node<Character> generateList(char[] array) {
        Node<Character> previous = null;
        Node<Character> head = null;
        for(Character value : array) {
            Node<Character> node = new Node(value);
            if (previous != null) {
                previous.setNext(node);
            } else {
                head = node;
            }
            previous = node;
        }
        return head;
    }

    public static class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}