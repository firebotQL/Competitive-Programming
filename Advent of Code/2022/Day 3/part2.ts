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
let rucksacksGroup: { [key: string]: boolean }[] = [];

file.split(/\r?\n/).forEach((line: string) => {
  const rucksack = line
    .split("")
    .reduce<{ [key: string]: boolean }>((acc, item) => {
      acc[item] = true;
      return acc;
    }, {});
  rucksacksGroup.push(rucksack);

  if (rucksacksGroup.length === 3) {
    const overlapping = characters.split("").filter((char) => {
      return (
        rucksacksGroup[0][char] &&
        rucksacksGroup[1][char] &&
        rucksacksGroup[2][char]
      );
    });

    result += overlapping.reduce((acc, item) => {
      return acc + priorities[item];
    }, 0);
    rucksacksGroup = [];
  }
});

console.log(result);
