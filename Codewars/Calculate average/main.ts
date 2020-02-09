export function findAverage(array: number[]): number {
  return array.reduce((sum, cur) => sum + cur, 0)/array.length;
}
