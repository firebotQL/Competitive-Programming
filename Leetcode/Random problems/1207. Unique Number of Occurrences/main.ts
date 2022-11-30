function uniqueOccurrences(arr: number[]): boolean {
  const countMap: { [key: number]: number } = arr.reduce(
    (currentMap, currentValue) => {
      if (currentMap[currentValue] === undefined) currentMap[currentValue] = 0;
      currentMap[currentValue] += 1;
      return currentMap;
    },
    {}
  );

  const occurences = Object.values(countMap);
  const uniqueOccurrences = new Set(occurences);
  return occurences.length === uniqueOccurrences.size;
}
