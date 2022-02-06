export function countPositivesSumNegatives(input: number[]): number[] {
  if (!input || !input.length) return [];
  return input.reduce((result, current) => {
    if (current > 0) result[0]++;
    else result[1] += current;
    return result;
  }, [0, 0]);
}
