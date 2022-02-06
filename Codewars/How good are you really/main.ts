export function betterThanAverage(classPoints: number[], yourPoints: number): boolean {
  return classPoints.reduce((sum, cur) => sum + cur, 0)/classPoints.length < yourPoints
}
