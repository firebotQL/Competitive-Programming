export function basicOp(operation: string, value1: number, value2: number): number {
  return ({
    '+': (a: number, b: number) => a + b,
    '-': (a: number, b: number) => a - b,
    '*': (a: number, b: number) => a * b,
    '/': (a: number, b: number) => a / b,
    } as { [key: string]: Function; })[operation](value1, value2);
}
