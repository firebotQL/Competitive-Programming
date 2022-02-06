export function getGrade(a: number, b: number, c: number) {
  const mean: number = (a + b + c) / 3;
  if (mean < 60) return 'F';
  if (mean < 70) return 'D';
  if (mean < 80) return 'C';
  if (mean < 90) return 'B';
  return 'A';
}
