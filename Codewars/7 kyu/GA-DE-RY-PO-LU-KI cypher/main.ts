export const cypher: string = 'GADERYPOLUKI';

export const offset = (idx: number) => idx % 2 === 0 ? 1 : -1;

export const map = (cypher + cypher.toLowerCase()).split('').reduce((res, char, idx, arr) => {
  res[char] = arr[idx + offset(idx)];
  return res;
}, {});

export const fn = (str: String): String => str.split('').map((char) => map[char] || char).join('')

export const encode = (str: String): String => fn(str);

export const decode = (str: String): String => fn(str);
