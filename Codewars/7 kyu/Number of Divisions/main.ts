export function divisions(n: number, divisor: number): number {
  let cnt: number = 0;
  while(Math.floor(n /= divisor) >= 1) cnt++;
  return cnt;
}
