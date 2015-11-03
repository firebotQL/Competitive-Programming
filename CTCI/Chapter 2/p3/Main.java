/*
 * 2.3 Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.
 */
public class Main {
    public static void main(String[] args) {
        Node<Integer> head = getLinkedList();
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>(head);
        deleteItem(sll, 6);
        printLinkedList(head);
    }

    /**
     * TODO: Some scenarios not covered up. Sort out later...
     */
    private static void deleteItem(SinglyLinkedList<Integer> sll, int i) {
        Node<Integer> current = sll.getHead();
        Node<Integer> replace = null;
        Node<Integer> previous = null;
        // 1. if only have head
        if (current != null && current.getNext() == null) {
            if (current.getValue() == i) {
                sll.setHead(null);
            }
        }

        while(current != null) {
            printLinkedList(sll.getHead());
            if (current.getValue() == i) {
                if (replace == null) {
                    replace = current;
                }
            } else if (replace != null) {
                replace.setValue(current.getValue());
                if (current.getNext() != null) {
                    replace = replace.getNext();
                } else {
                    replace.setNext(null);
                }
            }
            if (current.getValue() != i) {
                previous = current;
            }
            current = current.getNext();
        }

        printLinkedList(sll.getHead());

        if (previous != null) {
            previous.setNext(null);
        }

        if(replace != null) {
            replace.setNext(null);
        }
    }

    private static void printLinkedList(Node<Integer> node) {
        while(node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }


    public static Node<Integer> getLinkedList() {
        Node<Integer> head = new Node<Integer>(1);
        Node<Integer> node1 = new Node<Integer>(2);
        Node<Integer> node2 = new Node<Integer>(3);
        Node<Integer> node3 = new Node<Integer>(6);
        Node<Integer> node4 = new Node<Integer>(3);
        Node<Integer> node5 = new Node<Integer>(2);
        Node<Integer> node6 = new Node<Integer>(6);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node4.setNext(node6);
        return head;
    }

    public static class SinglyLinkedList<T> {
        private Node<T> head = null;

        public SinglyLinkedList(Node<T> head) {
            this.head = head;
        }

        public Node<T> getHead() {
            return head;
        }

        public void setHead(Node<T> head) {
            this.head = head;
        }
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

        public void setValue(T value) { this.value = value; }
    }
}
