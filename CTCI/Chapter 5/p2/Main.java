/**
 * Binary to String: Given a real number between 0 and 1 (e.g. 0.72) that is passed in as a double, print
 * the binary representation. If the number cannot be represented accurately in binary with at most 32 characters,
 * print "ERROR".
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(printInBinary(0.72));
        System.out.println(printInBinary(0.05));
        System.out.println(printInBinary(0.25));
    }

    private static String printInBinary(double number) {
        if (number < 0 || number > 1) return "ERROR";
        if (number == 1 || number == 0) return (int)number + "";
        StringBuffer result = new StringBuffer("0.");
        while(number > 0) {
            if (result.length() >= 32) return "ERROR";
            number *= 2;
            result.append((int) number);
            if (number >= 1) {
                number -= 1;
            }
        }
        return result.toString();
    }
}
