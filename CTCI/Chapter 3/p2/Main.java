import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        stack.push(2);
        stack.printStacks();
        stack.push(2);
        stack.printStacks();
        stack.push(5);
        stack.printStacks();
        stack.push(3);
        stack.printStacks();
        stack.push(1);
        stack.printStacks();
        stack.pop();
        stack.printStacks();
        stack.pop();
        stack.printStacks();
        stack.pop();
        stack.printStacks();
        stack.pop();
        stack.printStacks();
        stack.pop();
        stack.printStacks();
    }

    public static class Stack {
        int[] stack = new int[100];
        int[] minStack = new int[100];

        int min = Integer.MAX_VALUE;
        int currentIdx;
        int currentMinIdx;

        public void push(int item) {
            validate(currentIdx);
            if (min >= item) {
                minStack[currentMinIdx++] = item;
                min = item;
            }
            stack[currentIdx++] = item;
        }

        public int pop() {
            validate(currentIdx - 1);
            int value = stack[--currentIdx];
            if (value == minStack[currentMinIdx - 1]) {
                min = minStack[--currentMinIdx];
            }
            return value;
        }

        public int min() {
            if (currentMinIdx == 0) {
                throw new NoSuchElementException();
            }
            return min;
        }

        private void validate(int idx) {
            if (idx < 0 || idx >= stack.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        public void printStacks() {
            System.out.print("Stack: ");
            for(int i = 0; i < currentIdx; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();

            System.out.print("Min-stack: ");
            for(int i = 0; i < currentMinIdx; i++) {
                System.out.print(minStack[i] + " ");
            }
            System.out.println();
        }
    }
}
