/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

object Main {

 // def findRecursively(list: List[])
  /**
   * @param args the command line arguments
   */
  def main(args: Array[String]): Unit = {
    var num = Nil : List[Array[Int]]
	for((line) <- scala.io.Source.fromFile("data.txt").getLines) {
		num = num ::: List((line split ' ') map (_.toInt))
	}
    for(i <- num.length-2 to 0 by -1; j <- 0 to num(i).length-1) {
      num(i)(j) += Math.max(num(i+1)(j),num(i+1)(j+1))
	}
    println(num(0)(0)) 
  }
}
