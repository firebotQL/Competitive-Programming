/**
 * Draw Line: A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored
 * in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows). The
 * height of the screen, of course, can be derived from the length of the array and the width. Implement a function
 * that draws a horizontal line from (x1, y) to (x2, y).
 *
 * The method signature should look something like:
 * drawLine(byte[] screen, int width, int x1, int x2, int y)
 */
public class Main {
    public static void main(String[] args) {
        drawLine(new int[16], 32, 9, 19, 2);
        drawLine(new int[16], 32, 17, 19, 1);
        drawLine(new int[16], 32, 3, 27, 1);
    }

    // using int instead of bytes to represent unsigned byte
    // counting x1, x2 and y from 0
    public static void drawLine(int[] screen, int width, int x1, int x2, int y) {
        int mask = 0xff; // hex mask for 8-bits as zeroes;
        int x1Offset = x1 % 8;
        int x1ByteIdx = x1 / 8;
        int x2partPixel = x2 % 8;
        int x2ByteIdx = x2 / 8;
        int startByteIdx =  width / 8 * y;
        if (x1ByteIdx == x2ByteIdx) {
            screen[startByteIdx + x1ByteIdx] |= (mask >> x1Offset & mask << x2partPixel);
        } else if (x1ByteIdx < x2ByteIdx){
            screen[startByteIdx + x1ByteIdx] |= (mask >> x1Offset);
            ++x1ByteIdx;
            for (; x1ByteIdx < x2ByteIdx; x1ByteIdx++) {
                screen[startByteIdx + x1ByteIdx] |= mask;
            }
            screen[startByteIdx + x1ByteIdx] |= ((mask << x2partPixel) & mask);
        }
        drawScreen(screen, width);
    }


    public static void drawScreen(int[] screen, int width) {
        int cnt = 0;
        for(Integer element : screen) {
            String result = String.format("%8s", Integer.toBinaryString(element)).replace(' ', '0');
            System.out.print(result + " ");
            if (++cnt*8 % width == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
