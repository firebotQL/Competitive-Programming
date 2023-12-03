import * as fs from "fs";
const file1 = fs.readFileSync("./input1.txt", "utf8");
const file2 = fs.readFileSync("./input2.txt", "utf8");
const decimal = "(\\d)"
const numberRegexPart1 = new RegExp(`${decimal}`, "g");
const numberMap: {
  [key: string]: number;
} = {
  one: 1,
  two: 2,
  three: 3,
  four: 4,
  five: 5,
  six: 6,
  seven: 7,
  eight: 8,
  nine: 9,
};
const numbersList = Object.keys(numberMap);
const numbersListRev = Object.keys(numberMap).map((number) => [...number].reverse().join(''));
const getSearchRegex = (list: string[]): RegExp => {
  return new RegExp(`${decimal}|(${list.join(')|(')})`);
}
const numberRegexPart2 = getSearchRegex(numbersList);
const numberRegexPart2Rev = getSearchRegex(numbersListRev);

const solvePart1 = (): number => {
  return file1.split(/\r?\n/).reduce((acc: number, line: string) => {
    const numberGroups = line.match(numberRegexPart1) || [];
    return (
      acc + Number(`${numberGroups[0]}${numberGroups[numberGroups.length - 1]}`)
    );
  }, 0);
};

const solvePart2 = (): number => {
  return file2.split(/\r?\n/).reduce((acc: number, line: string) => {
    const startNumber = line.match(numberRegexPart2) || [];
    const endNumber = [...line].reverse().join('').match(numberRegexPart2Rev) || [];
    return (
      acc +
      Number(
        `${getNumber(startNumber[0]!)}${getNumber(endNumber[0]!)}`
      )
    );
  }, 0);
};

const getNumber = (match: string): number => {
  return numberMap[match] || numberMap[match.split('').reverse().join('')] || Number(match);
};

console.log(solvePart2());
