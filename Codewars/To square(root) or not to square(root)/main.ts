export function squareOrSquareRoot(array:number[]) : number[] {
  return array.map((num) => Math.sqrt(num) % 1 === 0 ? Math.sqrt(num) : Math.pow(num, 2));
}
