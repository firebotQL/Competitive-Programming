import scala.collection.mutable.HashMap

object EulerProject17 {
	val treasureMap = HashMap[Int, String] (
		1000 -> "thousand",
		100 -> "hundred",
		90 -> "ninenty",
		80 -> "eighty",
		70 -> "seventy",
		60 -> "sixty",
		50 -> "fifty",
		40 -> "fourty",
		30 -> "thirty",
		20 -> "twenty",
		19 -> "nineteen",
		18 -> "eighteen",
		17 -> "seventeen",
		16 -> "sixteen",
		15 -> "fifteen",
		14 -> "fourteen",
		13 -> "thirteen",
		12 -> "twelve",
		11 -> "eleven",
		10 -> "ten",
		9 -> "nine",
		8 -> "eight",
		7 -> "seven",
		6 -> "six",
		5 -> "five",
		4 -> "four",
		3 -> "three",
		2 -> "two",
		1 -> "one"
	)

	def main(args: Array[String]) : Unit = {
		treasureMap foreach ( (t2) => println(t2._1 + "-->" + t2._2))
		var div : Int = -1
		var divisor : Int = -1
		//for(i <- 1 until 1000) {
		var i : Int = 917
			for((key, value) <- treasureMap) {
				div = i
				println(key + " " + value)
				/*while ({divisor = div / key; divisor != 0}) {
					println("key: " + key + " divisor: " + divisor)
					if (div >= 100) 
						print(treasureMap.get(divisor) + " ")
					print(treasureMap.get(div) + " ")
					div = div % key 
				} */
			}
			println()
		//}
	}
}
