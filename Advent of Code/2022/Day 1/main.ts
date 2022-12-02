import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let maxCalories = [
  Number.MIN_SAFE_INTEGER,
  Number.MIN_SAFE_INTEGER,
  Number.MIN_SAFE_INTEGER,
];
let currentMax = 0;
file.split(/\r?\n/).forEach((line) => {
  if (line.trim().length === 0) {
    if (maxCalories[2] <= currentMax) {
      maxCalories.push(currentMax);
      maxCalories.shift();
    } else if (maxCalories[1] <= currentMax) {
      maxCalories[0] = maxCalories[1];
      maxCalories[1] = currentMax;
    } else if (maxCalories[0] <= currentMax) {
      maxCalories[0] = currentMax;
    }

    currentMax = 0;
    return;
  }
  currentMax += parseInt(line);
});

// console.log(maxCalories);

console.log(maxCalories[2]);
console.log(maxCalories[0] + maxCalories[1] + maxCalories[2]);
