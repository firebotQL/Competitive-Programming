export function addingShifted (arrayOfArrays:number[][], shift:number):number[] {
  const len = arrayOfArrays[0].length;
  const leftShift: number = len - shift;
  const array: number[] = [...Array(shift * arrayOfArrays.length + leftShift)].fill(0);
  let current: number = 0;
  return ([] as number[]).concat(...arrayOfArrays).reduce((result, num, idx) => {
    array[current++] += num;
    if ((idx + 1) % len === 0) current -= leftShift;
    return array;
  }, array);
}
