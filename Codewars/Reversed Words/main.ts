export function reverseWords(str: string): string {
  return str.split(/\s+/).reverse().join(' ');
}
