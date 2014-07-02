object EulerProject17 {

	private def getPair(input: String) = {
	  var split = input split ' '
	  Some(split(0), split(1))
	}
	
	lazy val power: (Int, Int) => Int = (x: Int, y: Int) => {
	  if (y == 0) {
	    1
	  } else {
	    x * power(x, y-1)
	  }
	} 
	
/*	def getLetterCount(numbersMap: Map[Int, String] , number: Int, digitNr: Int ) : Int = {
	  if (number == 0) {
	    number
	  } else {
	    var digit = number % 10
	    var part = 0
	    print(digitNr + " ")
	    if (digitNr < 1) {	// one digit 
	       println(numbersMap(digit))
	       part = numbersMap(digit).length() 
	    } else if (digitNr == 1) { // two digits
	       println(numbersMap(digit * power(10, digitNr)))
	       if (digit == 1) {
	    	   part = numbersMap(digit * power(10, digitNr)).length()
	       }
	    } else if (digitNr > 1 && digit != 0){ // three digits
		   println(numbersMap(digit) + " " + numbersMap(power(10, digitNr)))
		   part = numbersMap(digit).length() + numbersMap(power(10, digitNr)).length()
	    }
	   
		part + getLetterCount(numbersMap, number / 10, digitNr + 1)
	  }
	} */
	
	def getLetterCount(numbersMap: Map[Int, String] , number: Int) : Int = {
		var sum = 0;
		var value = number % 100
		var digit = 0
		
		if (value < 20) {
		  println(numbersMap(value))
		  sum += numbersMap(value).length();
		} else {
		  println(numbersMap(value/10 * power(10, 1)) + numbersMap(value%10))
		  sum += numbersMap(value/10 * power(10, 1)).length() + numbersMap(value%10).length();
		}
		val val1 = number / 100 % 10
		val val2 = number / 1000 % 10
		
		if (val1 != 0) {
			println(numbersMap(val1) + " " + numbersMap(power(10, 2)) + " ")
			if (sum != 0) {
			  sum += 3
			}
			sum += numbersMap(val1).length() + numbersMap(power(10, 2)).length() //
		}
		
		if (val2 != 0) {
			println(numbersMap(val2) + " " + numbersMap(power(10, 3)) + " ")
			sum += numbersMap(val2).length() + numbersMap(power(10, 3)).length()
		}
		sum
	}
	
	def main(args: Array[String]) : Unit = {
		val buffer = scala.io.Source.fromFile("numbers.txt")
		var numbersMap = buffer.getLines.foldLeft(Map[Int, String]())((b, line) =>  {
		  var temp = (line split ' ') map (a => a)
		  b.updated(temp(1).toInt, temp(0))
		}).updated(0, "")

		
		println ((1 to 1000).foldLeft(0) ( (b, a) => b + getLetterCount(numbersMap, a)))
	}
}