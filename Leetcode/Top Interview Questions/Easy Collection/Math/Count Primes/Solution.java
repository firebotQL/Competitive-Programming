class Solution {
    public int countPrimes(int n) {
        int cnt = 0;
        for(int i = 2; i < n; i++) {
            if (isPrime(i)) cnt++;
        }
        return cnt;
    }

    public boolean isPrime(int n) {
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        int i = 5;
        int w = 2;

        while(i * i <= n) {
            if (n % i == 0) return false;
            i += w;
            w = 6 - w;
        }
        return true;
    }
}
