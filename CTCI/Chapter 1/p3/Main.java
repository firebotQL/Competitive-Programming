/**
 * 1.3 Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at
 * the end to hold the additional characters, and that you are given the "true" length of the string. (Note: If
 * implementing in Java, please use a character array so that you can perform this operation in place.)
 */
public class Main {
    public static void main(String[] args) {
        String str = "Mr John Smith       ";
        System.out.println("\"" + getReplacedSpaces(str.toCharArray()) + "\"");
    }

    private static String getReplacedSpaces(char[] chars) {
        for(int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                shiftSpaces(chars, i);
                replaceSpaces(chars, i);
                i += 2;
            }
        }
        return new String(chars);
    }

    private static void shiftSpaces(char[] chars, int to) {
        for (int i = chars.length - 1; i > to+2; i--) {
            chars[i] = chars[i-2];
        }
    }

    private static void replaceSpaces(char[] chars, int i) {
        chars[i] = '%';
        chars[i+1] = '2';
        chars[i+2] = '0';
    }


}
