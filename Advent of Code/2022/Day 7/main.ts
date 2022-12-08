import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

class Tree {
  constructor(
    public height: number,
    public visible?: boolean,
    public nMax?: number,
    public sMax?: number,
    public wMax?: number,
    public eMax?: number
  ) {}
}

let row: number = 0;

const map: Tree[][] = file.split(/\r?\n/).reduce((map, line) => {
  for (let i = 0; i < line.length; i++) {
    if (!map[row]) map[row] = [];
    map[row].push(new Tree(+line[i]));
  }
  row++;
  return map;
}, [] as Tree[][]);

// Runtime - O(N*2N) => O(N^2)
const hydrateWithHorizonTreeHeights = (map: Tree[][]) => {
  for (let i = 0; i < map.length; i++) {
    let maxLeft = Number.MIN_SAFE_INTEGER;
    let maxTop = Number.MIN_SAFE_INTEGER;
    for (let j = 0; j < map[i].length; j++) {
      const treeR = map[i][j];
      treeR.wMax = maxLeft;
      maxLeft = Math.max(maxLeft, treeR.height);

      const treeC = map[j][i];
      treeC.nMax = maxTop;
      maxTop = Math.max(maxTop, treeC.height);
    }
    let maxRight = Number.MIN_SAFE_INTEGER;
    let maxBottom = Number.MIN_SAFE_INTEGER;
    for (let j = map[i].length - 1; j >= 0; j--) {
      const treeR = map[i][j];
      treeR.eMax = maxRight;
      maxRight = Math.max(maxRight, treeR.height);

      const treeC = map[j][i];
      treeC.sMax = maxBottom;
      maxBottom = Math.max(maxBottom, treeC.height);
    }
  }
};

// Runtime - O(N^2)
const setVisibleTreesAndReturnCount = (map: Tree[][]) => {
  let visibleCnt = 0;
  for (let i = 0; i < map.length; i++) {
    for (let j = 0; j < map[i].length; j++) {
      const tree = map[i][j];
      if (
        tree.height > tree.nMax! ||
        tree.height > tree.sMax! ||
        tree.height > tree.wMax! ||
        tree.height > tree.eMax!
      ) {
        tree.visible = true;
        visibleCnt++;
      }
    }
  }
  return visibleCnt;
};

hydrateWithHorizonTreeHeights(map);
console.log(setVisibleTreesAndReturnCount(map));
