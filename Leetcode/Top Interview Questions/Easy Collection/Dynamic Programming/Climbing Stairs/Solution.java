class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>(){
        {
            put(1, 1);
            put(2, 2);
        }
    };
    public int climbStairs(int n) {
        if (memo.get(n) == null) memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return memo.get(n);
    }
}
