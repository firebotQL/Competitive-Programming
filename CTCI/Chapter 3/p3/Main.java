import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SetOfStacks setOfStacks = new SetOfStacks();
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);

        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.popAt(0));
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
        System.out.println(setOfStacks.pop());
    }

    public static class SetOfStacks {
        private List<List<Integer>> setOfStacks = new ArrayList<List<Integer>>();
        private int maximum = 3;

        public void push(int item) {
            List<Integer> stack = null;

            int stackIdx = setOfStacks.size() - 1;
            if (stackIdx >= 0) {
                stack = setOfStacks.get(stackIdx);
            }

            boolean newStack = false;

            if (stack == null || stack.size() == maximum) {
                newStack = true;
                stack = new ArrayList<Integer>();
            }

            stack.add(item);

            if (newStack) {
                setOfStacks.add(stack);
            } else {
                setOfStacks.set(stackIdx, stack);
            }
        }

        public int pop() {
            return popAt(setOfStacks.size() - 1);
        }

        private int popAt(int stackIdx) {
            if (stackIdx < 0 || stackIdx >= setOfStacks.size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            List<Integer> stack = setOfStacks.get(stackIdx);
            if (stack.size() > 0) {
                return stack.remove(stack.size() - 1);
            }
            setOfStacks.remove(stackIdx);
            return popAt(stackIdx - 1);
        }
    }
}
