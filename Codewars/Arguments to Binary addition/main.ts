export function arr2bin(arr: any[]): string {
  return arr.filter((n) => typeof n === 'number').reduce((sum, n) => sum + n, 0).toString(2);
}
