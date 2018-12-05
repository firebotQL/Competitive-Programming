package com.company;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.IntStream;

class Main {
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm", Locale.ENGLISH);

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        ResultHelper tmpResult = br.lines()
                .map(Record::new)
                .sorted(Comparator.comparing(o -> o.timestamp))
                .collect(Collector.of(() -> new ResultHelper(),
                        (resultHelper, record) -> {
                            switch (record.action.charAt(0)) {
                                case 'G':
                                    resultHelper.currentGuardID = getGuardID(record.action);
                                    resultHelper.idToGuard.putIfAbsent(resultHelper.currentGuardID, new HashMap<>());
                                    break;
                                case 'f':
                                    resultHelper.prevMinuteEntry = record.timestamp.getMinute();
                                    break;
                                case 'w':
                                    final Map<Integer, Integer> guard = resultHelper.idToGuard.get(resultHelper.currentGuardID);
                                    IntStream.range(resultHelper.prevMinuteEntry, record.timestamp.getMinute() - 1).forEach(minute -> {
                                        guard.putIfAbsent(minute, 0);
                                        guard.put(minute, guard.get(minute) + 1);
                                    });
                                    break;
                            }
                        },
                        (a1, a2) -> null,
                        a -> a
                ));

        printPartOneResult(tmpResult);
        printPartTwoResult(tmpResult);
    }

    private static void printPartTwoResult(ResultHelper tmpResult) {
        tmpResult.idToGuard.entrySet()
                .stream()
                .sorted(Comparator.comparing(o -> o.getValue().values().stream().mapToInt(Integer::intValue).max().orElse(-1), Comparator.reverseOrder()))
                .findFirst()
                .map(entry -> entry.getKey() * entry.getValue()
                        .entrySet()
                        .stream()
                        .max(getFirstMaximumMinute())
                        .map(Map.Entry::getKey).get())
                .stream()
                .forEach(System.out::println);
    }

    private static void printPartOneResult(ResultHelper tmpResult) {
        tmpResult.idToGuard.entrySet()
        .stream()
        .sorted(Comparator.comparing(o -> o.getValue().values().stream().mapToInt(Integer::intValue).sum(), Comparator.reverseOrder()))
        .findFirst()
        .map(entry -> entry.getKey() * entry.getValue()
                                     .entrySet()
                                     .stream()
                                     .max(getMaximumMinute())
                                     .map(Map.Entry::getKey).get())
        .stream()
        .forEach(System.out::println);
    }

    public static Comparator<Map.Entry<Integer, Integer>> getMaximumMinute() {
        return getFirstMaximumMinute().thenComparing(Map.Entry::getKey);
    }

    public static Comparator<Map.Entry<Integer, Integer>> getFirstMaximumMinute() {
        return Comparator.comparing(Map.Entry::getValue);
    }

    public static class ResultHelper {
        int currentGuardID;
        int prevMinuteEntry;
        Map<Integer, Map<Integer, Integer>> idToGuard = new HashMap<>();
    }

    public static int getGuardID(String line) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(line);
        m.find();
        return Integer.valueOf(m.group());
    }

    public static class Record {
        LocalDateTime timestamp;
        String action;
        public Record(String line) {
            String pattern = "\\[(.*)\\]\\s+(.*)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            if (m.find()) {
                timestamp = LocalDateTime.parse(m.group(1), formatter);
                action = m.group(2);
            }
        }
    }
}
