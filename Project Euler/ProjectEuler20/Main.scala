/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler20

object Main {

  /**
   * @param args the command line arguments
   */

  def factor(x: BigInt): BigInt ={
    var answer = 1 : BigInt
    if (x != 1) {
      answer = x * factor(x-1)
    }
    answer
  }

  def sum(x: BigInt): BigInt = {
    var answer = x
    var sum = 0 : BigInt
    while(answer != 0) {
      sum += answer % 10
      answer /= 10
    }
    sum
  }

  def main(args: Array[String]): Unit = {
    println(sum(factor(100)))
  }

}
