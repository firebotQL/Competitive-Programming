import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        String polymer = br.lines().collect(Collectors.toList()).get(0);
        System.out.println(solve(polymer));
        System.out.println(solve2(polymer));
    }

    private static int solve(String input) {
         return input.chars().mapToObj(c -> (char) c).collect(Collector.of(() -> new ArrayDeque<Character>(),
                 (result, currentCharacter) -> {
                    if (result.isEmpty()) result.push(Character.valueOf(currentCharacter));
                    else {
                        char lastCharacter = result.peek();
                        if (isReacting(lastCharacter, currentCharacter)) result.pop();
                        else result.push(currentCharacter);
                    }
                 },
                 (a1, a2) -> null,
                 a -> a)).size();
    }

    private static int solve2(String input) {
        return IntStream.range('a', 'z').reduce(Integer.MAX_VALUE, (min, currentCharacter) -> {
            String replaced = input.replaceAll("(?i)" + (char)currentCharacter, "");
            return Math.min(min, solve(replaced));
        });
    }

    public static boolean isReacting(char first, char second) {
        return Math.abs(first - second) == 32;
    }

}
