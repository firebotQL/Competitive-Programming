/**
 * Pairwise Swap: Write a program to swap odd and even bits in an integer with as few instructions as possible
 * (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
 */
public class Main {
    public static void main(String[] args) {
        int res1 = solve(1783);
        int res2 = solve(23);
        System.out.println("Decimal: " + res1 + " binary: " + Integer.toBinaryString(res1));
        System.out.println("Decimal: " + res2 + " binary: " + Integer.toBinaryString(res2));
    }

    public static int solve(int number) {
        // Applying even and odd hex bitmasks to the number
        int evenBits = number & 0xAAAAAAAA;
        int oddBits = number & 0x55555555;
        return evenBits >> 1 | oddBits << 1;
    }
}
