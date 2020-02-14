export function pingPong(startNumber: number, endNumber: number): string {
  return [...Array(endNumber - startNumber + 1).keys()].map((num) => {
    var result = num + startNumber;
    if (result % 3 === 0 && result % 5 === 0) return 'PingPong'; 
    else if (result % 3 === 0) return 'Ping';
    else if (result % 5 === 0) return 'Pong';
    return result;
  }).join(' ');
}
