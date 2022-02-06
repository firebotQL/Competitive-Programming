export function cubeChecker(volume: number, side: number): boolean{
  return volume > 0 && side > 0 && Math.pow(side, 3) === volume;
}
