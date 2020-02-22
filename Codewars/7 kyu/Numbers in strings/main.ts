export const solve = (s: string): number => Math.max(...s.split(/[a-z]/g).map((el) => +el));
