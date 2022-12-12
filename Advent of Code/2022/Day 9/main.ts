import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

class Node {
  constructor(public x: number, public y: number) {}
}

let prevHead = new Node(0, 0);
const head = new Node(0, 0);
const tail = new Node(0, 0);
const visited = new Set<string>([JSON.stringify(tail)]);

const moveTail = () => {
  if (Math.abs(head.x - tail.x) > 1 || Math.abs(head.y - tail.y) > 1) {
    tail.x = prevHead.x;
    tail.y = prevHead.y;
    visited.add(JSON.stringify(tail));
  }
};

file.split(/\r?\n/).forEach((line) => {
  const [direction, steps] = line.split(" ");
  for (let i = 0; i < +steps; i++) {
    prevHead = new Node(head.x, head.y);
    switch (direction) {
      case "U":
        head.y++;
        break;
      case "D":
        head.y--;
        break;
      case "R":
        head.x++;
        break;
      case "L":
        head.x--;
        break;
    }
    moveTail();
  }
});

console.log(visited.size);
