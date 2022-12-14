import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

const areBothElementsNumbers = (elementInOne: any, elementInTwo: any) =>
  Number.isInteger(elementInOne) && Number.isInteger(elementInTwo);

const areBothElementsArrays = (elementInOne: any, elementInTwo: any) =>
  Array.isArray(elementInOne) && Array.isArray(elementInTwo);

const compare = (left: any, right: any): boolean | undefined => {
  if (areBothElementsNumbers(left, right)) {
    if (left < right) return true;
    if (left > right) return false;
    return undefined;
  }

  if (areBothElementsArrays(left, right)) {
    const minLength = Math.min(left.length, right.length);
    for (let index = 0; index < minLength; index++) {
      const result: boolean | undefined = compare(left[index], right[index]);
      if (result !== undefined) return result;
    }
    return compare(left.length, right.length);
  }

  return compare([left].flat(), [right].flat());
};

const dividerPacketOne = [[2]];
const dividerPacketTwo = [[6]];

const solve = () => {
  const packets = file
    .split(/\r?\n/)
    .filter((line) => line)
    .map((line) => JSON.parse(line));
  packets.push(dividerPacketOne);
  packets.push(dividerPacketTwo);
  packets.sort((a, b) => {
    const compareResult = compare(a, b);
    if (compareResult === true) return -1;
    if (compareResult === false) return 1;
    return 0;
  });

  const [firstIndex, secondIndex] = packets.reduce((result, current, index) => {
    if (current === dividerPacketOne) result[0] = index + 1;
    if (current === dividerPacketTwo) result[1] = index + 1;
    return result;
  }, []);

  return firstIndex * secondIndex;
};

console.log(solve());
