/**
 * Paths with Sum: You are given a binary tree in which each node contains an integer value (which might be positive or
 * negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to
 * start or end at the root or a leaf, but it must go downwards (travelling only from parent nodes to child nodes).
 */
public class Main {
    public static int counter = 0;

    public static void main(String[] args) {
        int sum = 6;
        int[] abc = { 1, 3, 2, 4, -6, 2 };
        countSums(abc, sum);
        System.out.println(counter);
    }

    private static void countSums(int[] arr, int sum) {
        for(int i = 0; i < arr.length; i++) {
            int newSum = arr[i];
            for(int j = i + 1; j <= arr.length; j++) {
                if (newSum == sum) {
                    counter++;
                    System.out.println("i = " + i + " j = " + (j-1) + " : " + newSum);
                }
                if (j == arr.length) {
                    break;
                }
                newSum += arr[j];
            }
        }

    }
}
