public class Main {

    public static void main(String[] args) {
        ThreeWayStack tws = new ThreeWayStack<Integer>(Integer.class);
        tws.push(1, 0);
        tws.push(1, 1);
        tws.push(1, 2);
    }

    public static class ThreeWayStack<T extends Number> {
        private int defaultSize = 33;
        private T[] array;
        private int[] sizes = new int[3];   // Three
        public ThreeWayStack(Class<T> c) {
            array = (T[]) Array.newInstance(c, defaultSize);
        }

        public void push(T item, int stack) {
            array[getIndex(stack, false)] = item;
            sizes[stack]++;
        }

        public T peek(T item, int stack) {
            return array[getIndex(stack, true)];
        }

        public T pop(T item, int stack) {
            T result = array[getIndex(stack, true)];
            sizes[stack]--;
            return result;
        }

        private int getIndex(int stackIdx, boolean peek) {
            int offset = peek ? 1 : 0;
            switch(stackIdx) {
                case 0:
                    int idx =  validateIndex(sizes[0] - offset);
                    return idx;
                case 1:
                    int size = validateIndex(sizes[1] - offset);
                    idx = array.length / 2 + 1 + (int)(Math.pow(-1, size));
                    return idx;
                case 2:
                    idx = validateIndex(array.length - 1 - sizes[2] + offset);
                    return idx;
            }
            throw new IndexOutOfBoundsException();
        }

        private int validateIndex(int idx) {
            if (idx < 0 || idx >= array.length) {
                throw new IndexOutOfBoundsException();
            }
            return idx;
        }
    }
}