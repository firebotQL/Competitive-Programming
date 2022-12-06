import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

const rows = file.split(/\r?\n/);
let index = 4;

rows.forEach((line: string) => {
  console.log(line);
  while (index < line.length) {
    const charMap: { [key: string]: boolean } = {};
    charMap[line[index - 4]] = true;
    charMap[line[index - 3]] = true;
    charMap[line[index - 2]] = true;
    charMap[line[index - 1]] = true;
    if (Object.keys(charMap).length === 4) break;
    index++;
  }
});

console.log(index);
