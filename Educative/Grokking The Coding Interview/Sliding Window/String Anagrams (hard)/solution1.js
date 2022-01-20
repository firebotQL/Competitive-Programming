const find_string_anagrams = function(str, pattern) {
  result_indexes = [];
  let windowStart = 0;
  const freqMap = {}
  for (let i = 0; i < pattern.length; i++) {
    const char = pattern[i];
    if (!freqMap[char]) freqMap[char] = 0;
    freqMap[char] += 1;
  }

  let patternSize = pattern.length;
  for(let i = 0; i < str.length; i++) {
    const char = str[i];
    if (freqMap[char] > 0) {
      freqMap[char] -= 1;
      patternSize -= 1;
    } else {
      while (patternSize !== pattern.length) {
        const charToPutBack = str[windowStart++];
        if (freqMap[charToPutBack] >= 0) {
          freqMap[charToPutBack] += 1;
          patternSize += 1;
        }
      }
      if (freqMap[char] > 0) {
        freqMap[char] -= 1;
        patternSize -= 1;
      }
    }

    while (patternSize === 0) {
      const charToPutBack = str.charAt(windowStart);
      if (freqMap[charToPutBack] >= 0) {
        freqMap[charToPutBack] += 1;
        patternSize++;
      }
      result_indexes.push(windowStart);
      windowStart++;
    }
  }
  return result_indexes;
};
