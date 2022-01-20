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
  for(let windowEnd = 0; windowEnd < str.length; windowEnd++) {
    const rightChar = str[windowEnd];
    if (rightChar in freqMap) {
      freqMap[rightChar] -= 1;
      if (freqMap[rightChar] === 0) {
          patternSize -= 1;
      }
    }

    if (patternSize === 0) {
      result_indexes.push(windowStart);
    }

    if (windowEnd >= pattern.length - 1) {
      const leftChar = str[windowStart++];
      if (leftChar in freqMap) {
        if (freqMap[leftChar] === 0) {
            patternSize += 1;
        }
        freqMap[leftChar] += 1;
      }
    }
  }

  return result_indexes;
}
