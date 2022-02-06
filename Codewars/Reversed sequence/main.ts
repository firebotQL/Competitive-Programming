export const reverseSeq = (n: number): number[] => {
  return [...Array(n).keys()].map((el) => el + 1).reverse();
};
