import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let X = 1;

let signalStrenghs: number[] = [];

const calculateSignalStrength = (cycle: number, X: number) => {
  // console.log(cycle, X);
  if (cycle === 20 || (cycle - 20) % 40 === 0) {
    return X * cycle;
  }
};

const instructionCycles: { [key: string]: number } = {
  noop: 1,
  addx: 2,
};

const instructionExecution: { [key: string]: Function } = {
  noop: () => {
    for (var i = 0; i < instructionCycles["noop"]; i++) {
      cycle++;
      const signalStrenght = calculateSignalStrength(cycle, X);
      if (signalStrenght) signalStrenghs.push(signalStrenght);
    }
  },
  addx: (value: number) => {
    for (var i = 0; i < instructionCycles["addx"]; i++) {
      cycle++;
      const signalStrenght = calculateSignalStrength(cycle, X);
      if (i + 1 === instructionCycles["addx"]) X += value;
      if (signalStrenght !== undefined) signalStrenghs.push(signalStrenght);
    }
  },
};

let cycle = 0;

file.split(/\r?\n/).forEach((line) => {
  const [instruction, value] = line.split(" ");
  // console.log("instruction=", instruction, "value=", value);
  instructionExecution[instruction](+value);
});

console.log(signalStrenghs.reduce((acc, cur) => acc + cur, 0));
