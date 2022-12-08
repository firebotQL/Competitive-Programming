import * as fs from "fs";
const file = fs.readFileSync("input.txt", "utf8");

class Node {
  constructor(
    public name?: string,
    public type?: string,
    public size: number = 0,
    public parent?: Node | undefined,
    public children: Node[] = []
  ) {}

  public addChild(child: Node) {
    this.children.push(child);
  }

  public addSize(size: number) {
    this.size += size;
  }
}

const root = new Node("/", "dir");
let current: Node | undefined = root;

const lines = file.split(/\r?\n/);

const navigateToCorrectFolder = (parameter: string) => {
  switch (parameter) {
    case "..":
      current = current?.parent;
      break;
    case "/":
      current = root;
      break;
    default:
      current = current?.children.find((node) => node.name === parameter);
  }
};

for (let i = 0; i < lines.length; i++) {
  const line = lines[i];
  if (line.startsWith("$")) {
    const [placeholder, command, parameter] = line.split(" ");
    switch (command) {
      case "cd":
        navigateToCorrectFolder(parameter);
        break;
      case "ls":
        continue;
    }
  } else {
    const [dirOrSize, name] = line.split(" ");
    let node;
    if (dirOrSize.includes("dir")) {
      node = new Node(name, "dir", undefined, current);
    } else {
      node = new Node(name, "file", parseInt(dirOrSize), current);
    }
    current?.addChild(node);
  }
}

const hydrateFolderSizes = (currentNode: Node) => {
  const { children: nodes } = currentNode;
  for (const node of nodes) {
    if (node.type === "file") currentNode.addSize(node.size);
    if (node.type === "dir") currentNode.addSize(hydrateFolderSizes(node));
  }
  return currentNode.size;
};

const findMatchingFolder = (currentNode: Node, prefix: string) => {
  console.log(
    prefix,
    currentNode.name,
    `(${currentNode.type}, size=${currentNode.size})`
  );
  let result = 0;
  if (currentNode === undefined) return result;

  if (currentNode.type === "dir" && currentNode.size < 100000) {
    result += currentNode.size;
  }

  for (const childNode of currentNode.children) {
    result += findMatchingFolder(childNode, " " + prefix);
  }
  return result;
};

hydrateFolderSizes(root);

console.log(findMatchingFolder(root, "- "));
