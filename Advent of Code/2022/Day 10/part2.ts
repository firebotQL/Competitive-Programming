import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let cycle = 0;
let X = 1;
let CRT = "";

const instructionCycles: { [key: string]: number } = {
  noop: 1,
  addx: 2,
};

const drawOnCRT = () => {
  console.log(
    `During cycle  ${cycle + 1}: CRT draws pixel in position ${cycle}`
  );
  CRT += getSpriteByX(X)[cycle % 40];
  console.log("Current CRT row:", CRT);
  console.log(" ");
};

const instructionExecution: { [key: string]: Function } = {
  noop: () => {
    for (var i = 0; i < instructionCycles["noop"]; i++) {
      drawOnCRT();
      cycle++;
    }
  },
  addx: (value: number) => {
    for (var i = 0; i < instructionCycles["addx"]; i++) {
      drawOnCRT();
      cycle++;
      if (i + 1 === instructionCycles["addx"]) X += value;
      console.log(X);
    }
  },
};

const getSpriteByX = (X: number) => {
  const row = new Array(40);
  row.fill(".");
  row[X - (1 % 40)] = "#";
  row[X % 40] = "#";
  row[X + (1 % 40)] = "#";
  console.log("Sprite position:", row.join(""));
  return row;
};

const solve = () => {
  file.split(/\r?\n/).forEach((line) => {
    const [instruction, value] = line.split(" ");
    console.log(
      `Start cycle   ${cycle + 1}: begin executing ${instruction} ${
        value ?? ""
      }`
    );
    instructionExecution[instruction](+value);
    console.log("     ");
  });
};

const printCRT = () => {
  let row = "";
  console.log(CRT.length);
  for (let i = 0; i < CRT.length; i++) {
    if (i % 40 === 0) {
      console.log(row);
      row = "";
    }
    row += CRT[i];
  }
  console.log(row);
};

solve();
printCRT();
