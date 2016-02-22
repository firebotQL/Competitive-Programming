/**
 * Next Number: Given a positive integer, print the next smallest and the next largest number that have the same
 * number of 1 bits in their binary representation.
 */
public class Main {
    public static void main(String[] args) {
        solve1(1783);
        solve2(1783);
    }

    public static int getBit(int num, int i) {
        return (num & (0b1 << i)) != 0 ? 1 : 0;
    }

    public static int updateBit(int num, int bit, int index) {
        int mask = ~(1 << index);
        return num & mask | (bit << index);
    }

    /** Can make more elegant by splitting into 3 loops O(2*m) where m is binary length **/
    private static void solve2(int number) {
        int size = 32 - Integer.numberOfLeadingZeros(1783);
        int maxFlipIdx = -1;
        int minFlipIdx = -1;
        int tmpNumber = -1;
        boolean flippedZero = false;
        for (int i = 0; i <= size; i++) {
            if (!flippedZero) {
                if (getBit(number, i) == 0) {
                    flippedZero = true;
                    tmpNumber = updateBit(number, 1, i);
                } else {
                    maxFlipIdx = i;
                }
            } else {
                if (getBit(number, i) == 1) {
                    minFlipIdx = i;
                    break;
                }
            }
        }

        int min = updateBit(tmpNumber, 0, minFlipIdx);
        int max = updateBit(tmpNumber, 0, maxFlipIdx);

        System.out.println("Minimum: " + min + " binary: " + Integer.toBinaryString(min));
        System.out.println("Maximum: " + max + " binary: " + Integer.toBinaryString(max));
    }

    /** Brute force solution **/
    public static void solve1(int number) {
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        String binary = Integer.toBinaryString(number);
        System.out.println("Original: " + binary);
        for(int i = 0; i < binary.length() - 1; i++) {
            for(int j = i + 1; j < binary.length(); j++) {
                String newBinary = binary.substring(0, i) +
                        binary.charAt(j) +
                        binary.substring(i+1, j) +
                        binary.charAt(i) +
                        binary.substring(j+1, binary.length());
                Integer newNumber = Integer.parseInt(newBinary, 2);
                if (newNumber > number) {
                    max = Integer.min(max, newNumber);
                } else if (newNumber < number) {
                    min = Integer.max(min, newNumber);
                }
            }
        }
        System.out.println("Minimum: " + min + " binary: " + Integer.toBinaryString(min));
        System.out.println("Maximum: " + max + " binary: " + Integer.toBinaryString(max));
    }
}
