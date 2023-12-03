import * as fs from "fs";
const file1 = fs.readFileSync("./input1.txt", "utf8");
const file2 = fs.readFileSync("./input2.txt", "utf8");

const schematic: string[] = file1.split(/\r?\n/);
const schematic2: string[] = file2.split(/\r?\n/);

const directions = {
  l: [-1, 0],
  r: [1, 0],
  u: [0, -1],
  d: [0, 1],
  lu: [-1, -1],
  ld: [-1, 1],
  ru: [1, -1],
  rd: [1, 1],
}

const solvePart1 = (): number => {
  return schematic.reduce((acc: number, line: string, currentRowIndex: number) => {
    for(const match of line.matchAll(/\d+/g)) {
      const currentStartColumnIndex = match.index!;
      const number = match[0];
      let from = currentStartColumnIndex;
      let to = currentStartColumnIndex + number.length;
      let isAdjacent = false;
      while(from < to && !isAdjacent) {
        for(const direction of Object.values(directions)) {
          let [dx, dy] = direction;
          let currentChar = schematic[currentRowIndex + dx]?.charAt(from + dy);
          if (/[^\w\.]/g.test(currentChar)) {
            acc += Number(number);
            isAdjacent = true;
            break;
          }
        }
        from++;
      }
    }
    return acc;
  }, 0);
};

const solvePart2 = (): number => {
  return Object.values(schematic2.reduce((acc: {[key: string]: number[]}, line: string, currentRowIndex: number) => {
    for(const match of line.matchAll(/\d+/g)) {
      const currentStartColumnIndex = match.index!;
      const number = match[0];
      let from = currentStartColumnIndex;
      let to = currentStartColumnIndex + number.length;
      let isAdjacent = false;
      while(from < to && !isAdjacent) {
        for(const direction of Object.values(directions)) {
          let [dx, dy] = direction;
          let [x, y] = [currentRowIndex + dx, from + dy];
          let currentChar = schematic2[x]?.charAt(y);
          if (/\*/g.test(currentChar)) {
            acc[`${x},${y}`] = (acc[`${x},${y}`] ?? []);
            acc[`${x},${y}`].push(Number(number))
            isAdjacent = true;
            break;
          }
        }
        from++;
      }
    }
    return acc;
  }, {})).reduce((acc: number, current: number[]) => {
    if (current.length === 2) {
      const [partNumberOne, partNumberTwo] = current;
      acc += partNumberOne * partNumberTwo;
    }
    return acc;
  }, 0);
};

console.log(solvePart2());
