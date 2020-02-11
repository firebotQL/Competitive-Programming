export function countSheep(num: number): string {
  return [...Array(num).keys()].reduce((res, cur) => res + `${cur + 1} sheep...`, '');
}
