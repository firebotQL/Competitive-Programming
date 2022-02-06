export function stackHeight2d(layers: number) {
  if (layers <= 1) return layers;
  return Math.sqrt(Math.pow(layers - 1, 2) - Math.pow((layers - 1)/2, 2)) + 1;
}
