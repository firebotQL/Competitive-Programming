export function goals (...goals: number[]): number {
  return goals.reduce((sum: number, goals: number) => sum + goals, 0);
}
