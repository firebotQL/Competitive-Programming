function getShortestUniqueSubstring(arr, str) {
  const charMap = {};
  for(let i = 0; i < arr.length; i++) {
    const char = arr[i];
    if (!charMap[char]) charMap[char] = 0;
    charMap[char] += 1;
  }
  
  let matched = 0;
  let startWindow = 0;
  let minimumArr = [];
  for(let endWindow = 0; endWindow < str.length; endWindow++) {
    const rightChar = str[endWindow];
    if (charMap[rightChar] !== undefined) {
      if (charMap[rightChar] > 0) {
        matched++;
      }
      charMap[rightChar] -= 1;
    }
    
    while(matched === arr.length) {
        if (minimumArr.length === 0 || 
           minimumArr[1] - minimumArr[0] > (1 + endWindow) - startWindow) {
          minimumArr = [startWindow, endWindow + 1];
        }
        const leftChar = str[startWindow++];
        if (charMap[leftChar] !== undefined) {
          if (charMap[leftChar] >= 0) {
            matched--;
          }
          charMap[leftChar] += 1;
        }
    }
  }
  return minimumArr.length === 0 ? '' : str.substring(minimumArr[0], minimumArr[1]);
}
