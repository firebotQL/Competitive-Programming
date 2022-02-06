export { get_age };

function get_age(age: string): number {
  return Number(age.charAt(0));
}
