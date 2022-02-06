export function isReallyNaN(val: any): boolean {
  return typeof val === 'number' && isNaN(val);
};
