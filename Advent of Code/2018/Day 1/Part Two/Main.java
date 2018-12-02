import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.concurrent.atomic.AtomicLong;

class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Long> values = br.lines().map(Long::valueOf).collect(Collectors.toList());
        AtomicLong frequency = new AtomicLong(0);
        Set<Long> frequencies = new HashSet<>(){{ add(0l); }};
        IntStream.iterate(0, n -> frequencies.add(frequency.addAndGet(values.get(n))), n -> (n + 1) % values.size()).count();
        System.out.println(frequency);
    }

}
