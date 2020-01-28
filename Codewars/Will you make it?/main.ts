export const zeroFuel = (distance: number, mpg: number, fuelLeft: number): boolean => {
  return distance - (mpg * fuelLeft) <= 0;
};
