/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler15

object Main {

  /**
   * 
   * @param list contains pairs
   */
  def findRecursively(row: Long, column: Long): Long = {
   if (column != 0)
    (((row + 1 - column)) * findRecursively(row, column - 1))/column
   else
     1 
  }
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
          print(findRecursively(2*20, 20))
  }

}
