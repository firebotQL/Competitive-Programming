import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let result = 0;

const characters = "0abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
const priorities = characters
  .split("")
  .reduce<{ [key: string]: number }>((acc, char, i) => {
    acc[char] = i;
    return acc;
  }, {});
let count = 0;

file.split(/\r?\n/).forEach((line: string) => {
  const compartmentOne = line.substring(0, line.length / 2).split("");
  const compartmentTwo = line.substring(line.length / 2).split("");
  const itemsCounts = compartmentOne.reduce<{ [key: string]: boolean }>(
    (acc, item) => {
      acc[item] = true;
      return acc;
    },
    {}
  );
  const overlapping = [
    ...new Set(compartmentTwo.filter((item) => itemsCounts[item])),
  ];

  result += overlapping.reduce((acc, item) => {
    return acc + priorities[item];
  }, 0);
});

console.log(result);
