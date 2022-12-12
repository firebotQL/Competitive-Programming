import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

class Node {
  constructor(public xy: number[], public name: string) {}
  toJSON() {
    return `${this.name} (${this.xy[0]}, ${this.xy[1]})`;
  }
}

const knotsCount = 10;
const knots = Array<Node>();
const visited = [new Node([0, 0], "T")];
const hashVisit = new Set<string>([JSON.stringify(new Node([0, 0], "T"))]);

let gridSizeRows = Number.MIN_SAFE_INTEGER;
let gridSizeCols = Number.MIN_SAFE_INTEGER;

let gridRowOffset = Number.MIN_SAFE_INTEGER;
let gridColOffset = Number.MIN_SAFE_INTEGER;

file.split(/\r?\n/).forEach((line) => {
  const [direction, steps] = line.split(" ");
  if (direction == "U" || direction == "D") {
    gridSizeRows = Math.max(gridSizeRows, +steps + 1);
  }
  if (direction == "R" || direction == "L") {
    gridSizeCols = Math.max(gridSizeCols, +steps + 1);
  }
});

const getGridOffset = () => {
  for (const knot of knots) {
    const [x, y] = knot.xy;
    if (x <= 0) {
      gridColOffset = Math.max(gridColOffset, Math.abs(x));
    }
    if (y <= 0) {
      gridRowOffset = Math.max(gridRowOffset, Math.abs(y));
    }
  }
};

const printGrid = () => {
  getGridOffset();
  console.log("Printing grid", " x: ", gridSizeCols, " y: ", gridSizeRows, "");
  const grid = Array<Array<string>>(gridSizeRows);
  // 1. Initialize grid
  for (let i = 0; i < gridSizeRows; i++) {
    grid[i] = new Array<string>(gridSizeCols);
    for (let j = 0; j < gridSizeCols; j++) {
      grid[i][j] = ".";
    }
  }
  // 2. Fill grid
  console.log(JSON.stringify(knots));
  for (const knot of knots) {
    const [x, y] = knot.xy;
    let nx = x + gridColOffset;
    let ny = y + gridRowOffset;
    if (grid[ny][nx] === ".") grid[ny][nx] = knot.name;
  }
  // 3. Print grid
  for (let i = gridSizeRows - 1; i >= 0; i--) {
    let result = "";
    for (let j = 0; j < gridSizeCols; j++) {
      result += grid[i][j];
    }
    console.log(result);
  }
};

const printVisited = () => {
  getGridOffset();
  console.log("Printing grid", " x: ", gridSizeCols, " y: ", gridSizeRows, "");
  const grid = Array<Array<string>>(gridSizeRows);
  // 1. Initialize grid
  for (let i = 0; i < gridSizeRows; i++) {
    grid[i] = new Array<string>(gridSizeCols);
    for (let j = 0; j < gridSizeCols; j++) {
      grid[i][j] = ".";
    }
  }
  // 2. Fill grid
  console.log(JSON.stringify(visited));
  for (const knot of visited) {
    const [x, y] = knot.xy;
    let nx = x + gridColOffset;
    let ny = y + gridRowOffset;
    if (grid[ny][nx] === ".") grid[ny][nx] = "#";
  }
  // 3. Print grid
  for (let i = gridSizeRows - 1; i >= 0; i--) {
    let result = "";
    for (let j = 0; j < gridSizeCols; j++) {
      result += grid[i][j];
    }
    console.log(result);
  }
};

const moveKnots = () => {
  console.debug("");
  console.debug("Moving knots of size: ", knots.length, "");
  console.debug("Before movement:", JSON.stringify(knots));
  for (let i = 0; i < knots.length - 1; i++) {
    const head = knots[i];
    const tail = knots[i + 1];
    if (head && tail) {
      const [hx, hy] = head.xy;
      const [tx, ty] = tail.xy;
      let ntx = tx,
        nty = ty;
      if (hx === tx && Math.abs(hy - ty) > 1) {
        nty = ty + (Math.sign(hy - ty) == 1 ? 1 : -1);
      } else if (hy === ty && Math.abs(hx - tx) > 1) {
        ntx = tx + (Math.sign(hx - tx) == 1 ? 1 : -1);
      } else if (
        hx !== tx &&
        hy !== ty &&
        (Math.abs(hx - tx) > 1 || Math.abs(hy - ty) > 1)
      ) {
        nty = ty + (Math.sign(hy - ty) == 1 ? 1 : -1);
        ntx = tx + (Math.sign(hx - tx) == 1 ? 1 : -1);
      }

      if (ntx !== tx || nty !== ty) {
        tail.xy = [ntx, nty];
        if (i + 1 === knots.length - 1) {
          hashVisit.add(JSON.stringify(tail));
          visited.push(new Node([...tail.xy], tail.name));
        }
      }
    }
  }

  console.log("After movement:", JSON.stringify(knots));
};

const directionMap: { [key: string]: number[] } = {
  U: [0, 1],
  D: [0, -1],
  R: [1, 0],
  L: [-1, 0],
};

const getKnotName = (knotNumber: number) => {
  if (knotNumber === 0) return "H";
  if (knotNumber === knotsCount - 1) return "T";
  return knotNumber;
};

const fillAllKnots = () => {
  for (let i = 0; i < knotsCount; i++) {
    knots.push(new Node([0, 0], `${getKnotName(i)}`));
  }
};

const solve = () => {
  file.split(/\r?\n/).forEach((line) => {
    const [direction, steps] = line.split(" ");
    console.log(" ");
    console.log("== ", direction, " ", steps, " ==");
    console.log(" ");
    for (let i = 0; i < +steps; i++) {
      const head = knots[0];
      const [cx, cy] = head.xy;
      const [nx, ny] = directionMap[direction];
      head.xy = [cx + nx, cy + ny];
      moveKnots();
    }
    //printGrid();
  });
};

fillAllKnots();
solve();
//printVisited();

console.log(hashVisit.size);
