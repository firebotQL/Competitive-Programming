import java.util.Scanner;

public class QuickSortInPlace {

    public static void main(String[] args) {
        int[] arr = read();
        quicksort(arr, 0, arr.length - 1);
    }

    private static int[] read() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n ;i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    private static void quicksort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            print(arr);
            quicksort(arr, lo, p - 1);
            quicksort(arr, p + 1, hi);
        }
    }

    public static void print(int[] arr) {
        for (Integer val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int pivot = arr[hi];
        for (int j = lo; j < hi; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
