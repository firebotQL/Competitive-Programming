export function getScore(arr: number[]) {
  return arr.reduce((game: number[], linesCleaned: number) => {
    const level = Math.floor(game[1] / 10);
    return [game[0] + [0, 40, 100, 300, 1200][linesCleaned] * (level + 1), game[1] + linesCleaned];
  }, [0, 0])[0];
}
