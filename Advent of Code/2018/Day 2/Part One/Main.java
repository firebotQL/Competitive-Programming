import java.io.*;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));

        final Long checkSum = br.lines().map(line -> line.chars()
                                                        .mapToObj(c -> (char) c)
                                                        .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                                                        .entrySet()
                                                        .stream()
                                                        .filter(entry -> entry.getValue() == 2 || entry.getValue() == 3)
                                                        .collect(Collectors.groupingBy(Map.Entry::getValue)))
                .collect(Collector.of(() -> new long[2],
                        (result, map) -> {
                            if (map.get(2l) != null) result[0] += 1;
                            if (map.get(3l) != null) result[1] += 1;
                        },
                        (result1, result2) -> {
                            result1[0] += result2[0];
                            result1[1] += result2[1];
                            return result1;
                        },
                        result -> result[0] * result[1]
                ));
        System.out.println(checkSum);
    }
}
