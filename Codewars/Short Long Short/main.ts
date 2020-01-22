export function shortLongShort(a:string, b:string): string {
  return a.length > b.length ? b + a + b : a + b + a;
}
