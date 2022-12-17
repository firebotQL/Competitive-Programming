import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let minX = Number.MAX_SAFE_INTEGER;
let maxX = Number.MIN_SAFE_INTEGER;
let maxY = Number.MIN_SAFE_INTEGER;

class RockPart {
  constructor(public x: number, public y: number) {}
}

const setMinMaxes = (x: number, y: number) => {
  minX = Math.min(minX, +x);
  maxX = Math.max(maxX, +x);
  maxY = Math.max(maxY, +y);
};

const printMap = (map: string[][]) => {
  for (const row of map) {
    console.log(row.join(""));
  }
};

const setRocksOnTheMap = (rocks: RockPart[][], map: string[][]) => {
  for (const rock of rocks) {
    for (let i = 0; i < rock.length - 1; i++) {
      const rockPartOne = rock[i];
      const rockPartTwo = rock[i + 1];
      const { x: x1, y: y1 } = rockPartOne;
      const { x: x2, y: y2 } = rockPartTwo;
      if (x1 === x2) {
        for (let y = Math.min(y1, y2); y <= Math.max(y1, y2); y++) {
          map[y][x1 - minX] = "#";
        }
      } else if (y1 === y2) {
        for (let x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
          map[y1][x - minX] = "#";
        }
      }
    }
  }
};

const withinBoundaries = (y: number, x: number) => {
  return x >= 0 && x <= maxX - minX && y >= 0 && y <= maxY;
};

const fallingThroughNext = (map: string[][], x: number, y: number) => {
  if (withinBoundaries(y + 1, x) && map[y + 1][x] === ".") {
    return x;
  }

  if (withinBoundaries(y + 1, x - 1) && map[y + 1][x - 1] === ".") {
    return x - 1;
  }

  if (withinBoundaries(y + 1, x + 1) && map[y + 1][x + 1] === ".") {
    return x + 1;
  }
};

const simulateSandFlow = (map: string[][]) => {
  let sandX = 500 - minX;
  let sandY = -1;
  let nextX = undefined;
  while ((nextX = fallingThroughNext(map, sandX, sandY)) !== undefined) {
    sandY++;
    sandX = nextX;
  }
  // Resting position
  if (
    withinBoundaries(sandY + 1, sandX - 1) &&
    withinBoundaries(sandY + 1, sandX + 1)
  ) {
    map[sandY][sandX] = "o";
    return true;
  } else {
    return false;
  }
};

const solve = () => {
  const rocks = file.split(/\r?\n/).map((line) => {
    return line.split(" -> ").map((rockCoordinates) => {
      const [x, y] = rockCoordinates.split(",");
      setMinMaxes(+x, +y);
      return new RockPart(+x, +y);
    });
  });
  // console.log(maxX);
  // console.log(minX);
  // console.log(maxX - minX);
  // const pouringPoint = 500 - minX;
  // console.log(pouringPoint);
  const map: string[][] = Array(maxY + 1)
    .fill(null)
    .map(() => Array(maxX - minX + 1).fill("."));
  setRocksOnTheMap(rocks, map);
  let sandInRest = 0;
  while (simulateSandFlow(map)) {
    sandInRest++;
  }
  console.log(sandInRest);
  printMap(map);
};

solve();
