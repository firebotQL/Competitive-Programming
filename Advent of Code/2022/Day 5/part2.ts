import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

const rows = file.split(/\r?\n/);
let stacks: Array<string>[] = [];

let simulation = false;

rows.forEach((line: string, index: number) => {
  // running simulation
  if (simulation) {
    const onlyActions = line.trim().match(/\d+/g);
    let amount = parseInt(onlyActions![0]);
    const from = parseInt(onlyActions![1]);
    const to = parseInt(onlyActions![2]);
    const tmp: Array<string> = [];
    while (amount--) {
      const popedCrate = stacks[from - 1].pop()!;
      tmp.unshift(popedCrate); // not efficient but oh well
    }
    stacks[to - 1] = [...stacks[to - 1], ...tmp];
  }
  // filling up all the stacks
  if (line.trim().length === 0) {
    const numberOfStacks = rows[index - 1].trim().split(/\s+/);
    stacks = Array.from(Array(numberOfStacks.length), () => []);

    for (let i = index - 2; i >= 0; i--) {
      for (let j = 0; j < numberOfStacks.length; j++) {
        const crate = rows[i][4 * j + 1];
        if (crate.trim().length !== 0) stacks[j].push(crate);
      }
    }
    simulation = true;
  }
});

console.log(stacks.reduce((acc, stack) => acc + stack.pop(), ""));
