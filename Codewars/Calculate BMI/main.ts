export function bmi(weight: number, height: number): string {
  const bmi: number = weight / Math.pow(height, 2);
  if (bmi <= 18.5) return "Underweight";
  if (bmi <= 25.0) return "Normal";
  if (bmi <= 30.0) return "Overweight";
  return "Obese";
}
