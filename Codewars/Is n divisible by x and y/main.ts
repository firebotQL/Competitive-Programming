export function isDivisible(n:number, x:number, y:number):boolean {
  return (n / x) % 1 === 0 && (n / y) % 1 === 0;
}
