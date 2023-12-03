import * as fs from "fs";
const file1 = fs.readFileSync("./input1.txt", "utf8");
const file2 = fs.readFileSync("./input2.txt", "utf8");

const matchingBag: {
  [key: string]: number;
} = {
  red: 12,
  green: 13,
  blue: 14
}

const solvePart1 = (): number => {
  return file1.split(/\r?\n/).reduce((acc: number, line: string) => {
    const [leftSide, rightSide] = line.split(':');
    const gameNumber = Number(leftSide!.match(/(\d+)/g)![0]);
    const possible = rightSide!.split(';').every((ballsSet: string) => {
        return ballsSet!.split(',').every((pickedBalls: string) => {
          const [, ballCount, colour] = pickedBalls.split(' ');
          return matchingBag[colour] >= Number(ballCount);
        });
    });
    return (
      acc + (possible ? gameNumber : 0)
    );
  }, 0);
};

const solvePart2 = (): number => {
  return file2.split(/\r?\n/).reduce((acc: number, line: string) => {
    const [, rightSide] = line.split(':');
    const minGameColours = rightSide!.split(/[,;]/).reduce((minColours: {
            [key: string]: number;
          }, pickedBalls: string) => {
          const [, ballCount, colour] = pickedBalls.split(' ');
          minColours[colour] = !minColours[colour] ? Number(ballCount) : Math.max(minColours[colour], Number(ballCount));

          return minColours;
        }, {
        });
    const power = Object.values(minGameColours).reduce((product: number, count: number) => product * count , 1);
    return (
      acc + power
    );
  }, 0);
};


console.log(solvePart2());
