function isIsomorphic(s: string, t: string): boolean {
  const stMap = {};
  const tsMap = {};
  for (let i = 0; i < s.length; i++) {
    const sch = s.charAt(i);
    const tch = t.charAt(i);
    if (!stMap[sch] && !tsMap[tch]) {
      stMap[sch] = tch;
      tsMap[tch] = sch;
    } else if (stMap[sch] !== tch && tsMap[tch] !== sch) {
      return false;
    }
  }
  return true;
}
