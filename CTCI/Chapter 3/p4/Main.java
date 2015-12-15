package chapter3.p4;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        queue.queue(1);
        queue.queue(2);
        queue.queue(3);
        queue.queue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    public static class MyQueue<T> {
        private Stack<T> in = new Stack();
        private Stack<T> out = new Stack();

        public void queue(T item) {
            in.push(item);
        }

        public T dequeue() {
            if (out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.pop();
        }


    }
}
