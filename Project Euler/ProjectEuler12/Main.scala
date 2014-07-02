/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package projecteuler12

object Main {

  def getPrimePowerProduct(x: BigInt) : BigInt = {
      var number = x : BigInt
      var count = BigInt(0)
      var prod = BigInt(1)
      if (number % 2 == 0) {
        count += 1
        number /= 2
        while (number % 2 == 0) {
          count += 1
          number /= 2
        }
      }
      if (count != 0) {
        prod *= (count + 1)
      }
      count = 0
      var factor = 3 : BigInt
      var maxFactor = Math.sqrt(number.toDouble)
      while (number > 1 && factor.toDouble <= maxFactor) {
        if (number % factor == 0) {
          count +=1
          number /= factor
          while (number % factor == 0) {
            count += 1
            number /= factor
          }
        }
        maxFactor = Math.sqrt(number.toDouble)
        if (count != 0) {
          prod *= (count + 1)
        }
        count = 0
        factor += 2
      }

      if (number != 1) {
        prod *= 2
      }
      prod
    }

  def main(args: Array[String]): Unit = {
     var triangle = 0 : BigInt
     var incrementor = 1 : BigInt
     while(getPrimePowerProduct(triangle) < 500) {
      triangle += incrementor
      incrementor += 1 
     }
     println(triangle)
  }

}
