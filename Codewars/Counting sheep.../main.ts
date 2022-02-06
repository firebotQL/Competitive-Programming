export function countSheeps(arrayOfSheep: boolean[]): number {
  return arrayOfSheep.reduce((sum, current) => sum + (current ? 1: 0), 0);
}
