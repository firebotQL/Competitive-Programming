
object EulerProject17 {

	private def getPair(input: String) = {
	  var split = input split ' '
	  Some(split(0), split(1))
	}
	
	def main(args: Array[String]) : Unit = {
		val buffer = scala.io.Source.fromFile("numbers.txt")
		var numbersMap = buffer.getLines.map(getPair _)
		println (numbersMap)
		//var line = "test one"
		//(line split ' ') collect {  case Array(a) => a }
		/*for((line) <- ) {
			num = num ::: List((line split ' ') map (_.toInt))
		}
		var checkNum = 0
		var sum = 0;
		
		for(i <- 1000 to 1 by -1) {
			lastNum = i % 10
			num /= 10
			num.foreach(value => (sum += getValue(num, value))
		}*/
	}
}