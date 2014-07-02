object EulerProject14 {
	def iterSeq(x: BigInt): BigInt = {
		if ((x % 2) > 0)
			return x * 3 + 1
		else
			return x/2
	}
	def main(args: Array[String]) {
		var value = 1000000 : BigInt
		var count = 0 : BigInt
		var longestOwner = 0 : BigInt
		for(i <- 1 to 1000000) {
			var tempSum = i : BigInt
			value = i
			var ccount = 0 : BigInt
			while (value != 1) {
				value = iterSeq(value)
				tempSum += value
				ccount+=1
			}
			if (ccount > count) {
				count = ccount
				longestOwner = i
			}
				
		}
		println(longestOwner)
	}
}