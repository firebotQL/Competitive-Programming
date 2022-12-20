import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

const regex =
  /Sensor at x=(-*\d+), y=(-*\d+): closest beacon is at x=(-*\d+), y=(-*\d+)/g;
let minX = Number.MAX_SAFE_INTEGER;
let maxX = Number.MIN_SAFE_INTEGER;
let minY = Number.MAX_SAFE_INTEGER;
let maxY = Number.MIN_SAFE_INTEGER;
let yOffset = 0;
let xOffset = 0;
let searchableY = 10;

class Location {
  constructor(
    public x: number,
    public y: number,
    public type: string,
    public distance?: number
  ) {}
}

const initialiseOffsets = () => {
  xOffset = minX < 0 ? Math.abs(minX) : 0;
  yOffset = minY < 0 ? Math.abs(minY) : 0;
};

const setMinMaxes = (x: number, y: number) => {
  minX = Math.min(minX, x);
  maxX = Math.max(maxX, x);
  minY = Math.min(minY, y);
  maxY = Math.max(maxY, y);
};

const calculatePositions = (map: string[][]) => {
  return map[searchableY + yOffset].reduce(
    (sum, current) => sum + (current === "#" ? 1 : 0),
    0
  );
};

const printMap = (map: string[][]) => {
  for (let i = 0; i < map.length; i++) {
    const row = map[i];
    if (i === 10 + yOffset) {
      console.log("\x1b[36m%s\x1b[0m", row.join(""));
    } else {
      console.log(row.join(""));
    }
  }
};

const calculateManhattanDifference = (
  x1: number,
  y1: number,
  x2: number,
  y2: number
) => {
  return Math.abs(x1 - x2) + Math.abs(y1 - y2);
};

const fillMap = (map: string[][], locations: Location[][]) => {
  for (const location of locations) {
    const [sensor, beacon] = location;
    const { x: dx1, y: dy1 } = sensor;
    const { x: dx2, y: dy2 } = beacon;

    const x1 = dx1 + xOffset;
    const y1 = dy1 + yOffset;

    const x2 = dx2 + xOffset;
    const y2 = dy2 + yOffset;

    map[y1][x1] = sensor.type;
    map[y2][x2] = beacon.type;
  }
};

const setHashOnMap = (map: string[][], x: number, y: number) => {
  map[y][x] = map[y][x] === "." ? "#" : map[y][x];
};

// Calculate OFFSET for y and x!

const drawManhattanDistance = (map: string[][], locations: Location[][]) => {
  for (const location of locations) {
    const [sensor, beacon] = location;
    const { x: dx1, y: dy1 } = sensor;
    const { x: x2, y: y2 } = beacon;

    const manhattanDistance = calculateManhattanDifference(dx1, dy1, x2, y2);

    const x1 = dx1 + xOffset;
    const y1 = dy1 + yOffset;

    // console.log("Sensor", x1, y1);
    // if (x1 === 8 + xOffset && y1 === 7 + yOffset) {
    //   console.log("Found sensor!");

    for (let i = 0; i < manhattanDistance + 1; i++) {
      setHashOnMap(map, x1 + i, y1);
      setHashOnMap(map, x1 - i, y1);
      setHashOnMap(map, x1, y1 + i);
      setHashOnMap(map, x1, y1 - i);
      for (let j = 0; j < manhattanDistance + 1 - i; j++) {
        setHashOnMap(map, x1 - j, y1 - i);
        setHashOnMap(map, x1 + j, y1 - i);
        setHashOnMap(map, x1 - i, y1 + j);
        setHashOnMap(map, x1 + i, y1 + j);
      }
    }
  }
  //}
};

const solve = () => {
  const locations = file.split(/\r?\n/).map((line) => {
    // console.log(line);
    const [full, sensorX, sensorY, beaconX, beaconY] = [
      ...line.matchAll(regex),
    ].flat();
    // console.log(sensorX, sensorY, beaconX, beaconY);
    const manDistance =
      calculateManhattanDifference(+sensorX, +sensorY, +beaconX, +beaconY) + 1;
    setMinMaxes(+sensorX - manDistance, +sensorY - manDistance);
    setMinMaxes(+sensorX + manDistance, +sensorY + manDistance);
    return [
      new Location(
        +sensorX,
        +sensorY,
        "S",
        calculateManhattanDifference(+sensorX, +sensorY, +beaconX, +beaconY)
      ),
      new Location(+beaconX, +beaconY, "B"),
    ];
  });
  initialiseOffsets();
  //console.log("xOffset", xOffset);
  //console.log("yOffset", yOffset);
  const map: string[][] = Array(maxY + yOffset)
    .fill(null)
    .map(() => Array(maxX + xOffset).fill("."));
  fillMap(map, locations);
  drawManhattanDistance(map, locations);
  // printMap(map);
  console.log(calculatePositions(map));
};

solve();
