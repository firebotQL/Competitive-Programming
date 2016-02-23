/**
 * Conversion: Write a function to determine the number of bits you would need to flip to convert
 * integer A to integer B.
 * EXAMPLE
 * Input: 29 (or: 11101), 15 (or: 01111)
 * Output: 2
 */
public class Main {
    public static void main(String[] args) {
        solve(29, 15);
    }

    public static void solve(int a, int b) {
        int N = a ^ b; // XOR
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            if ((N & (1 << i)) != 0) {
               cnt++;
            }
        }
        System.out.println("Number of bits to be flipped: " + cnt);
    }
}
