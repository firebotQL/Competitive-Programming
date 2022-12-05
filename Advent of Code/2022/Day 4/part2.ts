import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let result = 0;

file.split(/\r?\n/).forEach((line: string) => {
  const [elf1, elf2] = line.split(",");
  const [elf1Start, elf1End] = elf1.split("-").map((x) => parseInt(x));
  const [elf2Start, elf2End] = elf2.split("-").map((x) => parseInt(x));

  if (
    (elf1Start <= elf2Start && elf2Start <= elf1End) ||
    (elf2Start <= elf1Start && elf1Start <= elf2End)
  ) {
    result++;
  }
});

console.log(result);
