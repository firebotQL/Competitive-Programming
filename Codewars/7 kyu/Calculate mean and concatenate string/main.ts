export function mean(lst: string[]): [number, string] {
    return [
      lst.filter((val) => !isNaN(Number(val))).reduce((sum, val) => sum + Number(val), 0)/10,
      lst.filter((val) => isNaN(Number(val))).join(''),
    ];
}
