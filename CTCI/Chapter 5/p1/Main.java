import java.util.BitSet;

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
        int N = 1000000000;
        int M = 10011;
        int i = 2, j = 6;
        int tmpM = M;
        int resultN = N;
        while(i != j) {
            resultN = updateBit(resultN, tmpM % 10, i++);
            tmpM /= 10;
            if (tmpM == 0) {
                tmpM = M;
            }
        }
        System.out.println(resultN);
    }

    public static int updateBit(int num, int bit, int index) {
        int mask = ~(1 << index);
        return num & mask | (bit << index);
    }
}
