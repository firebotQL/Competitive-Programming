export function shuffledArray(shuffled: number[]): number[] {
  const sum = shuffled.reduce((sum, el) => sum + el, 0);
  const idx = shuffled.findIndex((el) => (sum - el) === el);
  shuffled.splice(idx, 1);
  return shuffled.sort((a,b) => a - b);
}
