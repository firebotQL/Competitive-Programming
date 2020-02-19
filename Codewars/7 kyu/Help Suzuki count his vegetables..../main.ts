export function countVegetables(s:string){
  const cntMap = s.split(' ').reduce((map, veg) => {
      let cnt = 0;
      if (map[veg]) cnt = map[veg];
      map[veg] = cnt + 1;
      return map;
    }, {});
  return Object.keys(cntMap).map((veg) => {
    return [cntMap[veg], veg];
  }).sort((a, b) => {
    if (b[0] !== a[0]) return b[0] - a[0];
    return b[1].localeCompare(a[1]);
  });
}
