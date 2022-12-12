import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let cycle = 0;

const monkeyIdMatch = /Monkey (\d+):/;
const startingItemsMatch = /Starting items: (.*)/;
const operationMatch = /Operation: new = old (.) (\w+)/;
const testMatch = /Test: divisible by (\d+)/;
const truePassMatch = /If true: throw to monkey (\d+)/;
const falsePassMatch = /If false: throw to monkey (\d+)/;

class Monkey {
  constructor(
    public id: number,
    public items?: number[],
    public operator?: string,
    public operand?: string,
    public test?: number,
    public truePassMonkey?: number,
    public falsePassMonkey?: number,
    public inspected: number = 0
  ) {}
  toJSON() {
    return `Monkey ${this.id}: ${this.items?.join(", ") ?? ""}`;
  }
}

const monkeys = new Map<number, Monkey>();
let currentMonkey: Monkey | undefined;

const createMonkey = (line: string) => {
  const [fullMatch, monkeyId] = line.match(monkeyIdMatch) || [];
  if (monkeyId) {
    currentMonkey = new Monkey(+monkeyId);
    monkeys.set(+monkeyId, currentMonkey);
  }
};

const setStartingItems = (line: string) => {
  const [fullMatch, items] = line.match(startingItemsMatch) || [];
  if (items && currentMonkey) {
    currentMonkey.items = items.split(", ").map((item) => +item);
  }
};

const setOperation = (line: string) => {
  const [fullMatch, operator, operand]: string[] =
    line.match(operationMatch) || [];
  if (operator && operand && currentMonkey) {
    currentMonkey.operator = operator;
    currentMonkey.operand = operand;
  }
};

const setTest = (line: string) => {
  const [fullMatch, test]: string[] = line.match(testMatch) || [];
  if (test && currentMonkey) {
    currentMonkey.test = +test;
  }
};

const setTruePass = (line: string) => {
  const [fullMatch, monkeyNr]: string[] = line.match(truePassMatch) || [];
  if (monkeyNr && currentMonkey) {
    currentMonkey.truePassMonkey = +monkeyNr;
  }
};

const setFalsePass = (line: string) => {
  const [fullMatch, monkeyNr]: string[] = line.match(falsePassMatch) || [];
  if (monkeyNr && currentMonkey) {
    currentMonkey.falsePassMonkey = +monkeyNr;
  }
};

const init = () => {
  file.split(/\r?\n/).forEach((line) => {
    createMonkey(line);
    setStartingItems(line);
    setOperation(line);
    setTest(line);
    setTruePass(line);
    setFalsePass(line);
  });
};

const calculateWorryLevel = (
  item: number,
  operator: string,
  operand: string
) => {
  const realOperand = operand === "old" ? item : +operand;
  switch (operator) {
    case "+":
      return item + realOperand;
    case "-":
      return item - realOperand;
    case "*":
      return item * realOperand;
    case "/":
      return item / realOperand;
  }
};

const printRoundLevels = (round: number) => {
  console.log(`Round ${round}:`);
  monkeys.forEach((monkey) => {
    console.log(JSON.stringify(monkey));
  });
};

const printMonkeyInspectionTimes = () => {
  monkeys.forEach(({ id, inspected }) => {
    console.log(`Monkey ${id} inspected ${inspected} items`);
  });
};

const calculateMonkeyBusiness = () => {
  const [mostActiveMonkeyOne, mostActiveMonkeyTwo] = [...monkeys.values()].sort(
    (a, b) => b.inspected - a.inspected
  );
  return mostActiveMonkeyOne.inspected * mostActiveMonkeyTwo.inspected;
};

const solve = () => {
  init();
  for (let round = 0; round < 20; round++) {
    for (const [monkeyId, monkey] of monkeys) {
      if (monkey.items) {
        const { operator, operand, truePassMonkey, falsePassMonkey } = monkey;
        monkey.items.forEach((item) => {
          const worryLevel = calculateWorryLevel(item, operator!, operand!);
          const boredWorryLevel = Math.floor(worryLevel! / 3);
          const monkeyToThrowTo =
            boredWorryLevel % monkey.test! === 0
              ? monkeys.get(truePassMonkey!)
              : monkeys.get(falsePassMonkey!);
          monkeyToThrowTo!.items!.push(boredWorryLevel);
          monkey.inspected++;
        });
        monkey.items = [];
      }
    }
    printRoundLevels(round + 1);
  }
};

solve();
printMonkeyInspectionTimes();
console.log(calculateMonkeyBusiness());
