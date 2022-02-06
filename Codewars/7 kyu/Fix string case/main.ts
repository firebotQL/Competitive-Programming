export function solve(s: string) {
  return s.length/2 <= s.split('').filter((el) => /[a-z]/.test(el)).length ? 
    s.toLowerCase() : s.toUpperCase();
}
