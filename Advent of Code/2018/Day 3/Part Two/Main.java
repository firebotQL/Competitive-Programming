import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        final long id = br.lines()
                .map(Claim::new)
                .collect(Collector.of(() -> new Result(),
                        (result, claim) -> {
                            IntStream.range(claim.x1, claim.x2).forEach(x -> {
                                IntStream.range(claim.y1, claim.y2).forEach(y -> {
                                    Map<Integer, Integer> row = result.gridOfIds.computeIfAbsent(x, k -> new HashMap<>());
                                    Integer foundID = row.get(y);
                                    if (foundID == null) {
                                        row.put(y, claim.id);
                                        result.mapOfIdStates.putIfAbsent(claim.id, true);
                                    } else {
                                        row.put(y, 0);
                                        result.mapOfIdStates.put(foundID, false);
                                        result.mapOfIdStates.put(claim.id, false);
                                    }
                                });p
                            });
                        },
                        (a1, a2) -> null,
                        a -> a
                ))
                .mapOfIdStates
                .entrySet()
                .stream()
                .filter(Map.Entry::getValue)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();

        System.out.println(id);
    }
    private static class Result {
        HashMap<Integer, HashMap<Integer, Integer>> gridOfIds = new HashMap<>();
        Map<Integer, Boolean> mapOfIdStates = new HashMap<>();
    }

    private static class Claim {
        final Integer id, x1, y1, x2, y2;

        public Claim(String line) {
            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(line);
            List<Integer> numbers = new ArrayList<>();
            while(m.find()){
                numbers.add(Integer.parseInt(m.group()));
            }
            id = numbers.get(0);
            x1 = numbers.get(1);
            y1 = numbers.get(2);
            x2 = x1 + numbers.get(3);
            y2 = y1 + numbers.get(4);
        }
    }

}
