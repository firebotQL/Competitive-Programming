object EulerProject17 {
	def getValue(number: Int, ar: Array[String, Int]): Int = {
		if (ar(1) == number) 
			ar(2).length
		0
	}
	def main(args: Array[String]) : Unit = {
		var num = Nil : List[Array[String, Int]]
		for((line) <- scala.io.Source.fromFile("numbers.txt").getLines) {
			num = num ::: List((line split ' ') map (_.toInt))
		}
		var checkNum = 0
		var sum = 0;
		for(i <- 1000 to 1 by -1) {
			lastNum = i % 10
			num /= 10
			num.foreach(value => (sum += getValue(num, value))
		}
	}
}