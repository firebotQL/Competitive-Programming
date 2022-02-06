export function howMuchILoveYou(petals: number): string | undefined {
  return ['I love you', 'a little', 'a lot', 'passionately', 'madly', 'not at all'].find((element, idx) => (petals - 1) % 6 === idx);
}
