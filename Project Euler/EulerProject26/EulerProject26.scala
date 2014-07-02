object ProjectEuler26 {
	def main(args: Array[Int]) : Unit = {
		var temp = 0 : Double
		var cycle = 0 : Long
		var count = 0 : Long
		var value = 0 : Long
		var matching = 0 : Long
		for(i <- 1 to 1000) {
			temp = 1/i.toDouble
			while(count != 17) {
				temp *= 10
				value = temp.toInt % 10
				cycle = cycle * 10 + value
				if (count == 0) {
					matching = cycle
				}
				if (count >= 1) {
					
				}
			}
			count += 1
		}
	}
}