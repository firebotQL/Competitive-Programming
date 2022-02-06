export function save(sizes: number[], hd: number) {
  return sizes.reduce((files: number, fileSize: number) => {
    if (hd >= fileSize) {
      hd -= fileSize;
      return ++files;
    } else {
      sizes.splice(1);
      return files;
    }
  }, 0);
}
