export function cartesianNeighbor(x: number, y: number): number[][] {
  return [[-1, -1], [-1, 0], [-1, 1], [0, -1], [0, 1], [1, -1], [1, 0], [1, 1]].map((el) => [el[0] + x, el[1] + y]);
}
