class Solution {
    public List<String> fizzBuzz(int n) {
        return IntStream.range(1, n + 1).mapToObj(i -> {
            if (i % 5 == 0 && i % 3 == 0) return "FizzBuzz";
            if (i % 5 == 0) return "Buzz";
            if (i % 3 == 0) return "Fizz";
            return String.valueOf(i);
        }).collect(Collectors.toList());
    }
}
