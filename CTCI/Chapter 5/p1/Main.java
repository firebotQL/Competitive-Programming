/**
 * Insertion: You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M
 * into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space to fit al lof M.
 * That is, if M = 10011, you can assume that there are at least 5 bits between j and i. You would not, for example,
 * have j = 3 and i =2, because M could not fully fit between bit 3 and bit 2.
 * Input: N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 100010001100
 */
public class Main {
    public static void main(String[] args) {
        int N = 0b10000000000;
        int M = 0b10011;
        int i = 2, j = 6;
        for(int ii = i; ii <= j; ii++) {
            N = updateBit(N, getBit(M, ii - i), ii);
        }
        System.out.println(Integer.toBinaryString(N));
    }

    public static int getBit(int num, int i) {
        return (num & (0b1 << i)) != 0 ? 1 : 0;
    }

    public static int updateBit(int num, int bit, int index) {
        int mask = ~(1 << index);
        return num & mask | (bit << index);
    }
}

