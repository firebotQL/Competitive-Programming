/**
 * 1.6 Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string,
 * your method should return the original string. You can assume the string
 * has only uppercase and lowercase letters (a - z).
 */
public class Main {
    public static void main(String[] args) {
        String input = "abbbbbc";
        System.out.println(compress(input));
    }

    private static String compress(String input) {
        int i = 0, j = 1;
        String result = "";
        for(; j < input.length(); j++) {
            char a = input.charAt(i);
            char b = input.charAt(j);
            if (a != b) {
                result += a + "" + (j - i);
                i = j;
            }
        }
        char a = input.charAt(i);
        result += a + "" + (j - i);
        return result.length() >= input.length() ? input : result;
    }
}
