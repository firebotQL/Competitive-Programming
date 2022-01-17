const longest_substring_with_k_distinct = function(str, k) {
  const charMap = 'abcdefghijklmnopqrstuvwxyz'.split('').reduce((res, cur) => {
    res[cur] = 0;
    return res;
  }, {});
  let uniqueCnt = 0, curLen = 0;
  let maxLen = Number.MIN_SAFE_INTEGER;
  let startWindow = 0;
  for(let i = 0; i < str.length; i++) {
    charMap[str[i]] += 1;
    curLen +=1;
    if (charMap[str[i]] === 1) {
       uniqueCnt += 1;
    }
    while(uniqueCnt > k) {
      maxLen = Math.max(maxLen, curLen - 1);
      charMap[str[startWindow]] -= 1;
      if (charMap[str[startWindow]] === 0) {
        uniqueCnt -= 1;
      }
      startWindow++;
      curLen--;
    }
  }
  return maxLen;
};
