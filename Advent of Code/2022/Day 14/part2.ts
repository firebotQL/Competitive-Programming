import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let minX = Number.MAX_SAFE_INTEGER;
let maxX = Number.MIN_SAFE_INTEGER;
let maxY = Number.MIN_SAFE_INTEGER;

let offset = -1;

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
      const { x: dx1, y: y1 } = rockPartOne;
      const { x: dx2, y: y2 } = rockPartTwo;
      const x1 = dx1 + offset;
      const x2 = dx2 + offset;
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

const withinBoundaries = (map: string[][], y: number, x: number) => {
  return y >= 0 && y < map.length && x >= 0 && x < map[y].length;
};

const fallingThroughNext = (map: string[][], x: number, y: number) => {
  if (withinBoundaries(map, y + 1, x) && map[y + 1][x] === ".") {
    return x;
  }

  if (withinBoundaries(map, y + 1, x - 1) && map[y + 1][x - 1] === ".") {
    return x - 1;
  }

  if (withinBoundaries(map, y + 1, x + 1) && map[y + 1][x + 1] === ".") {
    return x + 1;
  }
};

const simulateSandFlow = (map: string[][]) => {
  let sandX = 500 - minX + offset;
  let sandY = 0;
  let nextX = undefined;
  while ((nextX = fallingThroughNext(map, sandX, sandY)) !== undefined) {
    sandY++;
    sandX = nextX;
  }
  // Resting position
  if (
    withinBoundaries(map, sandY + 1, sandX - 1) &&
    withinBoundaries(map, sandY + 1, sandX + 1)
  ) {
    if (map[sandY][sandX] === "o") return false;
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

  maxY += 2;
  const columnCount = 2 * maxY + 4; // +2 for the extra columns on both sides
  const map: string[][] = Array(maxY + 1) // +2 for the extra rows
    .fill(null)
    .map((value, index, array) => {
      let fill = ".";
      if (index === array.length - 1) fill = "#";
      return Array(columnCount).fill(fill);
    });

  offset = columnCount / 2 - Math.floor((maxX - minX) / 2) + 10; // HOW DO WE FIGURE OUT OFFSET THE MIDDLE FOR THE ROCKS MAP?
  setRocksOnTheMap(rocks, map);
  let sandInRest = 0;
  while (simulateSandFlow(map)) {
    sandInRest++;
  }
  printMap(map);
  console.log(sandInRest);
};

solve();
