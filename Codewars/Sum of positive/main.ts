export function positiveSum(arr:number[]):number {
  return arr.filter((n) => n > 0).reduce((sum, cur) => sum + cur, 0);
}
