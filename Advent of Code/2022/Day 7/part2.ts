import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let row: number = 0;

const map: number[][] = file.split(/\r?\n/).reduce((map, line) => {
  for (let i = 0; i < line.length; i++) {
    if (!map[row]) map[row] = [];
    map[row].push(+line[i]);
  }
  row++;
  return map;
}, [] as number[][]);

const getViewingDistanceTop = (
  treeHeight: number,
  map: number[][],
  i: number,
  j: number
) => {
  let distance = 0;
  for (let k = i - 1; k >= 0; k--) {
    distance++;
    if (map[k][j] >= treeHeight) break;
  }
  return distance;
};

const getViewingDistanceBottom = (
  treeHeight: number,
  map: number[][],
  i: number,
  j: number
) => {
  let distance = 0;
  for (let k = i + 1; k < map.length; k++) {
    distance++;
    if (map[k][j] >= treeHeight) break;
  }
  return distance;
};

const getViewingDistanceLeft = (
  treeHeight: number,
  map: number[][],
  i: number,
  j: number
) => {
  let distance = 0;
  for (let k = j - 1; k >= 0; k--) {
    distance++;
    if (map[i][k] >= treeHeight) break;
  }
  return distance;
};

const getViewingDistanceRight = (
  treeHeight: number,
  map: number[][],
  i: number,
  j: number
) => {
  let distance = 0;
  for (let k = j + 1; k < map[i].length; k++) {
    distance++;
    if (map[i][k] >= treeHeight) break;
  }
  return distance;
};

const getMaxViewingDistance = (map: number[][]) => {
  let maxDistance = Number.MIN_SAFE_INTEGER;
  for (let i = 0; i < map.length; i++) {
    let maxLeft = 0;
    let maxTop = 0;
    let maxRight = 0;
    let maxBottom = 0;
    for (let j = 0; j < map[i].length; j++) {
      const treeHeight = map[i][j];
      const upDistance = getViewingDistanceTop(treeHeight, map, i, j);
      const downDistance = getViewingDistanceBottom(treeHeight, map, i, j);
      const leftDistance = getViewingDistanceLeft(treeHeight, map, i, j);
      const rightDistance = getViewingDistanceRight(treeHeight, map, i, j);
      maxDistance = Math.max(
        maxDistance,
        upDistance * leftDistance * downDistance * rightDistance
      );

      console.log(
        `treeHeight = ${treeHeight}`,
        "(",
        upDistance,
        "*",
        leftDistance,
        "*",
        downDistance,
        "*",
        rightDistance,
        ") - distance = ",
        upDistance * leftDistance * downDistance * rightDistance
      );
    }
  }
  return maxDistance;
};

console.log(getMaxViewingDistance(map));
