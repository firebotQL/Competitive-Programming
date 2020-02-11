export function grow(arr: number[]) {
  return arr.reduce((multi, cur) => multi * cur, 1);
}
