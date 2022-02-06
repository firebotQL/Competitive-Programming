export function findSmallestInt(args: number[]): number {
  return args.reduce((min, cur) => Math.min(min, cur),  Number.MAX_VALUE);  // or Math.min(...args);
}
