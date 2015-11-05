import java.io.IOException;
import java.util.Stack;

/**
 * 2.5 - You have two numbers represented by a linked list, where each node contains digit. The digits are stored
 * in reverse order, such that the 1's digit is at the head of the list function that adds two numbers and returns the sum as a linked list.
 *
 * Example:
 * (7->1->6) + (5->9->2). Tha is 617 + 295
 * 2->1->9 (912)
 * Suppose the digits are stored in forward order. Repeat the above problem
 * Example:
 * (6->1->7) + (2->9->5).That is 617 + 295
 * Output:
 * 9->1->2 That is (912)
 */
public class Playground {
    public static void main(String[] args) throws IOException {
        // Assuming that lists linked lists might have different lenghts;
        solveNormal();
        solveReverse();
    }

    private static void solveReverse() {
        int[] array = {6, 1, 7};
        int[] array2 = {2, 9, 5};
        Node<Integer> head1 = generateList(array);
        Node<Integer> head2 = generateList(array2);
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(head1 != null) {
            stack1.push(head1.getValue());
            head1 = head1.getNext();
        }
        while(head2 != null) {
            stack2.push(head2.getValue());
            head2 = head2.getNext();
        }
        int sum = 0;
        int cnt = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop() * Math.pow(10, cnt);
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop() * Math.pow(10, cnt);
            }
            cnt++;
        }
        System.out.println(sum);
    }

    public static void solveNormal() {
        int[] array = {7, 1, 6};
        int[] array2 = {5, 9, 2};
        Node<Integer> head1 = generateList(array);
        Node<Integer> head2 = generateList(array2);
        int sum1 = 0;
        int cnt = 0;
        while(head1 != null) {
            sum1 += head1.getValue() * Math.pow(10, cnt++);
            head1 = head1.getNext();
        }
        int sum2 = 0;
        cnt = 0;
        while(head2 != null) {
            sum2 += head2.getValue() * Math.pow(10, cnt++);
            head2 = head2.getNext();
        }
        System.out.println(sum1 + sum2);
    }

    public static Node<Integer> generateList(int[] array) {
        Node<Integer> previous = null;
        Node<Integer> head = null;
        for(Integer value : array) {
            Node<Integer> node = new Node(value);
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