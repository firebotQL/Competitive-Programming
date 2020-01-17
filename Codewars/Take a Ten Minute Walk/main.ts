interface Coordinates {
  [key: string]: number
}

const coordinate: { [key: string]: number; } = {
  n: 1,
  s: -1,
  w: -1,
  e: 1,
};

const directionToAxis: { [key: string]: string; } = {
  n: 'y',
  s: 'y',
  w: 'x',
  e: 'x',
};

export function isValidWalk(walk: string[]): boolean {
  if (walk.length != 10) return false;
  const endPosition: Coordinates = walk.reduce((currentPosition: Coordinates, direction: string) => {
    currentPosition[directionToAxis[direction]] += coordinate[direction];
    return currentPosition;
  }, { x: 0, y: 0 });
  return endPosition.x === 0 && endPosition.y === 0;
}
