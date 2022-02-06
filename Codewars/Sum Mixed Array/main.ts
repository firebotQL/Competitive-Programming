export function sumMix(x: any[]): number {
    return x.reduce((sum, cur) => sum + Number(cur), 0);
}
