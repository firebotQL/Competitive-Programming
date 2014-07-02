/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package projecteuler13

object Main {

import scala.io.Source
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    //var lines = scala.io.Source.fromFile("input.txt").getLines.mkString
    var sum = BigInt(0) : BigInt
     for {
      (line) <- Source.fromFile("input.txt").getLines
    } {
      sum += BigInt(line)
    }
    println(sum.toString.substring(0, 10))
  }

}
