export const strongNumber = (num: number): string => {
  const fact = (num) => num === 0 ? 1 : num * fact(num - 1);
  return ('' + num).split('').reduce((sum, el) => sum + fact(+el), 0) === num ? 'STRONG!!!!' : 'Not Strong !!';
};
