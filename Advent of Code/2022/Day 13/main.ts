import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

const areBothElementsNumbers = (elementInOne: any, elementInTwo: any) =>
  Number.isInteger(elementInOne) && Number.isInteger(elementInOne);
const areBothElementsArrays = (elementInOne: any, elementInTwo: any) =>
  Array.isArray(elementInOne) && Array.isArray(elementInOne);

const checkIfInOrder = (packetOne: any[], packetTwo: any[]): boolean => {
  let rightOrder = true;
  while (packetOne.length && packetTwo.length && rightOrder) {
    const elementInOne = packetOne.shift();
    const elementInTwo = packetTwo.shift();
    if (
      areBothElementsNumbers(elementInOne, elementInTwo) &&
      elementInOne > elementInTwo
    ) {
      rightOrder = false;
    } else if (areBothElementsArrays(elementInOne, elementInTwo)) {
      rightOrder = checkIfInOrder(elementInOne, elementInTwo);
    } else if (Number.isInteger(elementInOne)) {
      rightOrder = checkIfInOrder([elementInOne], elementInTwo);
    } else if (Number.isInteger(elementInTwo)) {
      rightOrder = checkIfInOrder(elementInOne, [elementInTwo]);
    }
  }

  return rightOrder && packetOne.length === 0 && packetTwo.length === 0;
};

let packets: any[][] = [];

let sumOfIndicesInRightOrder = 0;
const init = () => {
  file.split(/\r?\n/).forEach((line, index) => {
    if (!line) {
      const packetOne = packets[0];
      const packetTwo = packets[1];
      if (checkIfInOrder(packetOne, packetTwo)) {
        sumOfIndicesInRightOrder += index + index - 1;
      } else {
        console.log("Not in order");
        console.log("packetOne=", packetOne);
        console.log("packetTwo=", packetTwo);
      }

      return;
    }
    console.log(line);
    packets[index % 2] = JSON.parse(line);
    console.log(JSON.parse(line));
  });
};

const solve = () => {
  init();
};

solve();

console.log(sumOfIndicesInRightOrder);
