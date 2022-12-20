import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let start: Node;
let end: Node;
let heightMap: number[][];

class Node {
  constructor(public row: number, public col: number, public pathCnt: number) {}
  equals(other: Node) {
    return this.row === other.row && this.col === other.col;
  }
  toJSON() {
    return `${this.row} ${this.col}`;
  }
}

const init = () => {
  heightMap = file.split(/\r?\n/).map((line, row) =>
    line.split("").map((char, col) => {
      if (char === "S") {
        start = new Node(row, col, 0);
        return 1;
      }
      if (char === "E") {
        end = new Node(row, col, 0);
        return 26;
      }
      return char.charCodeAt(0) - 96;
    })
  );
};

const getNeighbors = (node: Node) => {
  const { row, col, pathCnt } = node;
  return [
    new Node(row - 1, col, pathCnt + 1),
    new Node(row + 1, col, pathCnt + 1),
    new Node(row, col - 1, pathCnt + 1),
    new Node(row, col + 1, pathCnt + 1),
  ];
};

const validNeighbor = (node: Node) => {
  const { row, col } = node;
  return (
    row >= 0 &&
    row < heightMap.length &&
    col >= 0 &&
    col < heightMap[row].length
  );
};

const notHigherThanHeightTwo = (current: Node, neighbor: Node) => {
  const currentNodeHeight = heightMap[current.row][current.col];
  const neighborNodeHeight = heightMap[neighbor.row][neighbor.col];
  return neighborNodeHeight - currentNodeHeight < 2;
};

const bfs = () => {
  const queue: Node[] = [start];
  const visited = new Set<string>();
  while (!queue[0]?.equals(end)) {
    const currentNode = queue.shift()!;
    if (visited.has(JSON.stringify(currentNode))) continue;
    visited.add(JSON.stringify(currentNode));
    const neighbors = getNeighbors(currentNode);
    neighbors.forEach((neighbor) => {
      if (
        !visited.has(JSON.stringify(neighbor)) &&
        validNeighbor(neighbor) &&
        notHigherThanHeightTwo(currentNode, neighbor)
      ) {
        queue.push(neighbor);
      }
    });
  }
  return queue[0].pathCnt;
};

const solve = () => {
  init();
  console.log(bfs());
};

solve();
