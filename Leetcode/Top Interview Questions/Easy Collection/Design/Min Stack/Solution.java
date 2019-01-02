class MinStack {
    LinkedList<Integer> list;
    LinkedList<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
         list = new LinkedList<Integer>();
         minStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        list.addFirst(x);
        if (minStack.isEmpty() || minStack.getFirst() >= x) {
            minStack.addFirst(x);
        }
    }

    public void pop() {
        int value = list.removeFirst();
        if (!minStack.isEmpty() && minStack.getFirst() == value) {
            minStack.removeFirst();
        }
    }

    public int top() {
        return list.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
