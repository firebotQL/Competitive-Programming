export function saleHotdogs(n: number): number {
  return (n < 5 ? 100 : n < 10 ? 95 : 90) * n;
}
