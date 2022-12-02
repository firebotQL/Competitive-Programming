import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

let winsum = 0;

// A - Rock, B - Paper, C - Scissors
// Y - Rock, Z - Paper, X - Scissors

const rules: { [key: string]: string } = {
  A: "Rock",
  B: "Paper",
  C: "Scissors",
};

const gameResultOutcomes: { [key: string]: string } = {
  X: "Loss",
  Y: "Draw",
  Z: "Win",
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

const getHand = (outcome: string, b: string) => {
  switch (outcome) {
    case "Win":
      if (b === "Rock") return "Paper";
      if (b === "Paper") return "Scissors";
      if (b === "Scissors") return "Rock";
    case "Loss":
      if (b === "Rock") return "Scissors";
      if (b === "Paper") return "Rock";
      if (b === "Scissors") return "Paper";
    case "Draw":
      if (b === "Rock") return "Rock";
      if (b === "Paper") return "Paper";
      if (b === "Scissors") return "Scissors";
  }
  return "Impossible";
};

file.split(/\r?\n/).forEach((line: string) => {
  const [opponentHand, outcomeCode] = line.split(" ");

  const opponentHandName = rules[opponentHand];
  const gameOutcome = gameResultOutcomes[outcomeCode];

  const handToPlay = getHand(gameOutcome, opponentHandName);
  winsum += gameResultScores[gameOutcome] + scores[handToPlay];
});

console.log(winsum);
