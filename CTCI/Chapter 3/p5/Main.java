import java.util.Stack;

/**
* Write a programm to sort a stack such taht the smallest items are on the top. You can use
* an additional temporary stack, but you may not copy the elements into any other data structure
* (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty 
.*/
public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        Stack<Integer> tmpStack = new Stack<Integer>();
        while(!stack.isEmpty()) {
            Integer element = stack.pop();
            while(!tmpStack.isEmpty() && tmpStack.peek() < element) {
                stack.push(tmpStack.pop());
            }
            tmpStack.push(element);
        }

        Stack<Integer> swap = stack;
        stack = tmpStack;
        tmpStack = swap;

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
