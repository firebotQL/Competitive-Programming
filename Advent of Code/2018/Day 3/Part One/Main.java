import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

       final long count = br.lines()
               .map(Claim::new)
               .collect(Collector.of(() -> new HashMap<Integer, HashMap<Integer, Integer>>(),
                           (map, claim) -> {
                               IntStream.range(claim.x1, claim.x2).forEach(x -> {
                                   IntStream.range(claim.y1, claim.y2).forEach(y -> {
                                       Map<Integer, Integer> row = map.computeIfAbsent(x, k -> new HashMap<>());
                                       Integer cnt = row.computeIfAbsent(y, k -> 0);
                                       row.put(y, cnt + 1);
                                   });
                               });
                           },
                       (a1, a2) -> null,
                       a -> a
                       )).values().stream()
               .flatMap(v -> v.values().stream())
               .filter(v -> v > 1)
               .count();
       System.out.println(count);
    }
}
