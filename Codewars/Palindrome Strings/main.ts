export function isPalindrome(line: string): boolean {
  return line.split('').every((el, idx) => el === line.charAt(line.length - idx - 1));
}
