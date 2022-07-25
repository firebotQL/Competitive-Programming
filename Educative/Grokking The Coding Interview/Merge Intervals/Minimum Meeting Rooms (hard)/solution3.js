function minMeetingRooms(intervals) {
  const [startArray, endArray] = intervals.reduce(
    (startAndEndArrays, interval) => {
      startAndEndArrays[0].push(interval[0]);
      startAndEndArrays[1].push(interval[1]);
      return startAndEndArrays;
    },
    [[], []]
  );

  startArray.sort((a, b) => a - b);
  endArray.sort((a, b) => a - b);

  for (let i = 0; i < startArray.length; i++) console.log(isNaN(endArray[i]));
  console.log(JSON.stringify(startArray));
  console.log(JSON.stringify(endArray));

  let usedRooms = 0;
  let endIndex = 0;
  for (let startIndex = 0; startIndex < startArray.length; startIndex++) {
    if (startArray[startIndex] >= endArray[endIndex]) {
      endIndex++;
    } else {
      usedRooms++;
    }
  }

  return usedRooms;
}
