const printDiagonals = (matrix) => {
  if (!matrix || matrix.length == 0) return;

  const columnCount = matrix[0].length;
  const rowCount = matrix.length;

  for(let column = 0; column < columnCount; column++) {
    let result = [];
    for(let row = 0; row <= column && row < rowCount; row++) {
        result.push(matrix[row][column - row])
    }
    console.log(result.join(' '));
  }

  for(let row = 0; row < rowCount; row++) {
    let result = [];
    for(let column = columnCount - 1; column >= 0 && row + columnCount - column < rowCount; column--) {
        result.push(matrix[row + columnCount - column][column]);
    }
    console.log(result.join(' '));
  }
}


// printDiagonals3([[1,2,3,4],[5,6,7,8],[9,10,11,12]])
// printDiagonals3([[1,2,3],[4,5,6],[7,8,9],[10,11,12]])
