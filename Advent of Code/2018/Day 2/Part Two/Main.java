import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    // Horrible stream solution as tried had iterative solution and
    // wanted to learn streams to convert
    // Failed :D
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        final List<String> lines = br.lines().collect(Collectors.toList());
        AtomicBoolean foundResult = new AtomicBoolean(false);
        IntStream.iterate(0, i -> i + 1).takeWhile(n -> !foundResult.get() && n < lines.size()).forEach(i -> {
            IntStream.iterate(i + 1, j -> j + 1).takeWhile(n -> !foundResult.get() && n < lines.size()).forEach(j -> {
                String line1 = lines.get(i);
                String line2 = lines.get(j);
                AtomicInteger dist = new AtomicInteger(0);
                StringBuilder sb = new StringBuilder();
                IntStream.iterate(0, n -> n + 1)
                        .takeWhile(n -> n < line1.length() && dist.get() <= 1)
                        .forEach(idx -> {
                            if (line1.charAt(idx) != line2.charAt(idx)) dist.incrementAndGet();
                            else sb.append(line1.charAt(idx));
                        });
                if (dist.get() == 1) {
                    foundResult.set(true);
                    System.out.println(sb.toString());
                }
            });
        });
    }
}
