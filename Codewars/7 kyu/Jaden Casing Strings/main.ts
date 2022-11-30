String.prototype.toJadenCase = function () {
  return this.split(/\s/)
    .map((word) => word.charAt(0).toUpperCase() + word.substring(1))
    .join(" ");
};

interface String {
  // Declaration needed, don't remove it
  toJadenCase(): string;
}
