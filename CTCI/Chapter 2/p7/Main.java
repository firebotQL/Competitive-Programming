import java.io.IOException;

/**
 * 2.7 Given two (singly) lined lists, determine if the two lists intersect. Return the intersecting node.
 * Node that the intersection is defined based on reference, not value, Tht is, if the kth node of the first linked list
 * is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        int[] data1 = {1, 2, 3, 13, 12, 14};
        int[] data2 = {4, 5, 6};
        int[] data3 = {7, 8, 9};
        // Scenario 1 (intersect)
        Node<Integer> common = generateList(data3, null);
        Node<Integer> list1 = generateList(data1, common);
        Node<Integer> list2 = generateList(data2, common);

        Result intersecting = isIntersecting(list1, list2);
        System.out.println("List 1 and List 2 is " + (!intersecting.isIntersect() ? "not" : "") + "intersecting" );
        if (intersecting.isIntersect()) {
            System.out.println("At list 1 position: " + intersecting.getJ() + " and list 2 position: " + intersecting.getK());
        }
        // Scenario 2 (doesn't intersect)
        list1 = generateList(data1, null);
        list2 = generateList(data2, null);
        intersecting = isIntersecting(list1, list2);
        System.out.println("List 1 and List 2 is " + (!intersecting.isIntersect() ? "not " : "") + "intersecting" );
        if (intersecting.isIntersect()) {
            System.out.println("At list 1 position: " + intersecting.getK() + " and list 2 position: " + intersecting.getJ());
        }
    }

    public static Result isIntersecting(Node<Integer> list1, Node<Integer> list2) {
        Node<Integer> head1 = list1;
        Node<Integer> head2 = list2;
        int length1 = 1;
        int length2 = 1;
        while(head1.getNext() != null) {
            length1++;
            head1 = head1.getNext();
        }
        while(head2.getNext() != null) {
            length2++;
            head2 = head2.getNext();
        }
        Result result = new Result(-1, -1, false);
        if (head1 == head2) {
            int pos = 1;
            int diff = Math.abs(length1 - length2);
            boolean first = false;
            if (length1 > length2) {
                first = true;
                while(length1 > length2) {
                    length1--;
                    list1 = list1.getNext();
                }
            } else if (length1 < length2) {
                while(length1 < length2) {
                    length2--;
                    list2 = list2.getNext();
                }
            }
            while(list1 != list2) {
                pos++;
                list1 = list1.getNext();
                list2 = list2.getNext();
            }
            result = new Result(pos + (!first ? diff : 0 ), pos + (first ? diff : 0), true);
        }
        return result;
    }

    public static Node<Integer> generateList(int[] array, Node<Integer> common) {
        Node<Integer> previous = null;
        Node<Integer> head = null;
        Node<Integer> node = null;
        for(Integer value : array) {
            node = new Node(value);
            if (previous != null) {
                previous.setNext(node);
            } else {
                head = node;
            }
            previous = node;
        }

        if (common != null) {
            node.setNext(common);
        }

        return head;
    }

    public static class Result {
        private int k;
        private int j;
        private boolean intersect = false;

        public Result(int k, int j, boolean intersect) {
            this.k = k;
            this.j = j;
            this.intersect = intersect;
        }

        public int getK() {
            return k;
        }

        public int getJ() {
            return j;
        }

        public boolean isIntersect() {
            return intersect;
        }
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