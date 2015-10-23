import java.util.HashSet;
import java.util.Set;

/**
 * 2.1  Write code to remove duplicates from an unsorted linked list.
 */
class Main {

    public static void main(String[] args) {
        Node<Integer> head = getLinkedList();
        removeDuplicates(head);
        printLinkedList(head);
    }

    public static void printLinkedList(Node<Integer> node) {
        while(node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
    }
    public static void removeDuplicates(Node<Integer> head) {
        Node<Integer> node = head;
        Node<Integer> prev = null;
        Set<Integer> used = new HashSet<Integer>();
        while(node != null) {
            if (!used.add(node.getValue())) {
                prev.setNext(node.getNext());
                node = prev;
            }
            prev = node;
            node = node.getNext();
        }
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