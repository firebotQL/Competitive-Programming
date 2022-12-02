import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let winsum = 0;

// A - Rock, B - Paper, C - Scissors
// Y - Rock, Z - Paper, X - Scissors

const rules: { [key: string]: string } = {
  A: "Rock",
  X: "Rock",
  B: "Paper",
  Y: "Paper",
  C: "Scissors",
  Z: "Scissors",
};

const scores: { [key: string]: number } = {
  Rock: 1,
  Paper: 2,
  Scissors: 3,
};

const gameResultScores: { [key: string]: number } = {
  Win: 6,
  Draw: 3,
  Loss: 0,
};

const getGameResult = (a: string, b: string) => {
  if (a === b) return "Draw";
  if (a === "Rock" && b === "Paper") return "Loss";
  if (a === "Rock" && b === "Scissors") return "Win";
  if (a === "Scissors" && b === "Rock") return "Loss";
  if (a === "Scissors" && b === "Paper") return "Win";
  if (a === "Paper" && b === "Scissors") return "Loss";
  if (a === "Paper" && b === "Rock") return "Win";
  return "Impossible";
};

file.split(/\r?\n/).forEach((line: string) => {
  const [opponentHand, myHand] = line.split(" ");

  const opponentHandName = rules[opponentHand];
  const myHandName = rules[myHand];

  const gameResult = getGameResult(myHandName, opponentHandName);
  winsum += gameResultScores[gameResult] + scores[myHandName];
});

console.log(winsum);
