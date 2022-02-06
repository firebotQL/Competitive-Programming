export function bigToSmall(arr: number[][]): string {  
  return ([] as number[]).concat(...arr).sort((a, b) => b - a).join('>');
}
