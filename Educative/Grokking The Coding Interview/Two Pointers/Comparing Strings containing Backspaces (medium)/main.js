const backspace_compare = function(str1, str2) {
  let ptr1 = str1.length - 1;
  let ptr2 = str2.length - 1;
  let rm1 = 0;
  let rm2 = 0;
  while(ptr1 >= 0 && ptr2 >= 0) {
     const char1 = str1[ptr1];
     const char2 = str2[ptr2];
     if (char1 === '#') {
       ptr1--;
       rm1++;
       continue
     } else if (rm1 > 0) {
       ptr1 -= rm1;
       rm1 = 0;
       continue;
     }

    if (char2 === '#') {
       ptr2--;
       rm2++;
       continue
     } else if (rm2 > 0) {
       ptr2 -= rm2;
       rm2 = 0;
       continue;
     }

      if (char1 !== char2) {
        return false;
      }
      ptr1--;
      ptr2--;
  }
  return ptr1 < 0 && ptr2 < 0;
};
