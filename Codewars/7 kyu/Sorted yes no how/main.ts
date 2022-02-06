export function isSortedAndHow(array:number[]): string {
  if (array.every((el, idx, arr) => idx === 0 || arr[idx - 1] >= el)) return "yes, descending";
  if (array.every((el, idx, arr) => idx === 0 || arr[idx - 1] <= el)) return "yes, ascending";
  return "no";
}
