import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

const rows = file.split(/\r?\n/);
let index = 4;

rows.forEach((line: string) => {
  console.log(line);
  while (index < line.length) {
    const charMap: { [key: string]: boolean } = {};
    for (let i = 1; i <= 14; i++) charMap[line[index - i]] = true;
    if (Object.keys(charMap).length === 14) break;
    index++;
  }
});

console.log(index);
