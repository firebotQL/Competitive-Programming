export function past(h: number, m: number, s: number): number {
  return ((h * 60 + m) * 60  + s) * 1000;
}
