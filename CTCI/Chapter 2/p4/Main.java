/*
 * 2.4 Write code to partition a linked list around a value x, such that all nodes less than x come
 * before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be
 * after the elements less than x (see below).
 */
public class Main {
    public static void main(String[] args) {
        Node<Integer> head = getLinkedList();
        Node<Integer> newHead = partition(head, 5);
        printLinkedList(newHead);
    }

    private static Node<Integer> partition(Node<Integer> head, int x) {
        Node<Integer> current = head.getNext();
        Node<Integer> tmpNode = new Node<Integer>(head.getValue());
        SinglyLinkedList<Integer> newSLL = new SinglyLinkedList<Integer>(tmpNode);
        while(current != null) {
            Node<Integer> node = new Node<Integer>(current.getValue());
            if (current.getValue() < x) {
                node.setNext(newSLL.getHead());
                newSLL.setHead(node);
            } else {
                newSLL.getTail().setNext(node);
                newSLL.setTail(node);
            }
            current = current.getNext();
        }
        return newSLL.getHead();
    }

    private static void printLinkedList(Node<Integer> node) {
        while(node != null) {
            System.out.print(node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }


    public static Node<Integer> getLinkedList() {
        Node<Integer> head = new Node<Integer>(3);
        Node<Integer> node1 = new Node<Integer>(5);
        Node<Integer> node2 = new Node<Integer>(8);
        Node<Integer> node3 = new Node<Integer>(5);
        Node<Integer> node4 = new Node<Integer>(10);
        Node<Integer> node5 = new Node<Integer>(2);
        Node<Integer> node6 = new Node<Integer>(1);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        return head;
    }

    public static class SinglyLinkedList<T> {
        private Node<T> head = null;
        private Node<T> tail = null;

        public SinglyLinkedList(Node<T> node) {
            head = tail = node;
        }

        public Node<T> getHead() {
            return head;
        }

        public void setHead(Node<T> head) {
            this.head = head;
        }

        public Node<T> getTail() {
            return tail;
        }

        public void setTail(Node<T> tail) {
            this.tail = tail;
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
