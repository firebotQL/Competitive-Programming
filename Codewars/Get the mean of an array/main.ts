export function getAverage(marks:number[]):number{
  return Math.floor(marks.reduce((sum, cur) => sum + cur, 0)/marks.length);
}
