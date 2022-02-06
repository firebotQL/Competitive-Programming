export function enough(cap: number, on: number, wait: number): number {
  return (on + wait) > cap ? (on + wait) - cap : 0;
}
