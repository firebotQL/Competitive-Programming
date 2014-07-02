object EulerProject48 {
	def power(num: Int, base: Int) : BigInt = {
		var number = BigInt(num)
		for (i <- 1 to base-1) 
			number *= num
		number
	}
	def main(args: Array[String]) {
		var sum = 0 : BigInt
		for ( i <- 1 to 1000)
			sum += power (i,i)
		var str = sum.toString
		println(str.substring(str.length-10))
	}
}