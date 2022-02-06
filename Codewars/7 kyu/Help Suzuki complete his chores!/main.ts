export function choreAssignment(chores: number[]) {
  return chores.sort((a,b) => a - b).reduce((result, cur, idx, src) => {
    if (idx === src.length / 2) src.splice(1);    // Stopping Reduce 
    else result.push(cur + src[src.length - idx - 1]);
    return result;
    }, []).sort((a, b) => a - b);
}
