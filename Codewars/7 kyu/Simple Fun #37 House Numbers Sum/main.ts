export function houseNumbersSum(inputArray: number[]): number {
  return inputArray.reduce((sum, cur, idx, arr) => {
    if (cur === 0) arr.splice(1);
    return sum + cur;
  }, 0);
}
