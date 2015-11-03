/**
 * 2.2 Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Main {
    public static void main(String[] args) {
        Node<Integer> head = getLinkedList();
        printKth(head, 4);
    }

    private static void printKth(Node<Integer> head, int k) {
        Node<Integer> first = head;
        Node<Integer> second = head;
        int i = 0;
        while(first != null) {
            if (i++ > k) {
               second = second.getNext();
            }

            first = first.getNext();
        }
        System.out.println(second.getValue());
    }

    public static Node<Integer> getLinkedList() {
        Node<Integer> head = new Node<Integer>(1);
        Node<Integer> node1 = new Node<Integer>(2);
        Node<Integer> node2 = new Node<Integer>(3);
        Node<Integer> node3 = new Node<Integer>(4);
        Node<Integer> node4 = new Node<Integer>(2);
        Node<Integer> node5 = new Node<Integer>(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        return head;
    }

    public static class Node<T> {
        private Node<T> next = null;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }
    }
}
