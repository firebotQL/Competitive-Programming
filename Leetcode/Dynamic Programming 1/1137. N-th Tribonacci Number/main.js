const memorization = {};
function tribonacci(n: number): number {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 1;
    if (memorization[n]) return memorization[n];
    return memorization[n] = tribonacci(n - 3) + tribonacci(n - 2) + tribonacci(n - 1);
};