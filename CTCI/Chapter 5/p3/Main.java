/**
 * Flip Bit to Win: You have an integer and you can flip exactly one bit from a 0 to a 1. Where code to find the length
 * of the longest sequence of 1s you could create.
 */
public class Main {
    public static void main(String[] args) {
        print(1783);
        print(62);
    }

    private static void print(int number) {
        String binary = Integer.toBinaryString(number);
        int foundIdx = -1;
        for(int i = binary.length()-1; i >= 0 ; i--) {
            if (binary.charAt(i) == '0') {
                String newBinary = new String(binary.substring(0, i) + "1" + binary.substring(i + 1, binary.length()));
                int newNumber = Integer.parseInt(newBinary, 2);
                if(newNumber > number) {
                    number = newNumber;
                    foundIdx = i;
                }
            }
        }

        System.out.println(binary.length() - 1 - foundIdx);
    }
}
