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
    for (let i = 0; i < Math.min(left.length, right.length); i++) {
      const result: boolean | undefined = compare(left[i], right[i]);
      if (result !== undefined) return result;
    }
    return compare(left.length, right.length);
  }

  return compare([left].flat(), [right].flat());
};

let packets: any[][] = [];

let sumOfIndicesInRightOrder = 0;
let pair = 1;

const solve = () => {
  file.split(/\r?\n/).forEach((line, index) => {
    if (!line) {
      const [leftPackets, rightPackets] = packets;
      if (compare(leftPackets, rightPackets)) {
        sumOfIndicesInRightOrder += pair;
        console.log("In order");
      } else {
        console.log("Not in order");
      }
      packets = [];
      pair++;
    } else {
      packets.push(JSON.parse(line));
    }
  });
};

solve();

console.log(sumOfIndicesInRightOrder);
