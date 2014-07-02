object EulerProject11 {
	def main(args: Array[String]) {
		var count = 3
		for {
			line <- io.Source.fromFile("input.txt").getLines()
		} {			
			var splitted = line.split(" ")			
			for(i <- 0 to splitted.length-1) {
				sum(count).update(i+3, splitted(i).toInt)
			}
			count += 1
		}
		
		var adjProd = -999
		for (i <- 3 to sum.length-4; j <- 3 to sum.length-4) {
				var tempProd = 0
				// Left Upper Diagonal
				tempProd = sum(i-3)(j-3)*sum(i-2)(j-2)*
					sum(i-1)(j-1)*sum(i)(j)
				if (tempProd > adjProd)
					adjProd = tempProd
				// Upper Vertical
				tempProd = sum(i-3)(j)*sum(i-2)(j)*
					sum(i-1)(j)*sum(i)(j)
				if (tempProd > adjProd)
					adjProd = tempProd
				// Right Upper Diagonal
				tempProd = sum(i-3)(j+3)*sum(i-2)(j+2)*
					sum(i-1)(j+1)*sum(i)(j)
				if (tempProd > adjProd)
					adjProd = tempProd
				// Right Horizontal
				tempProd = sum(i)(j+3)*sum(i)(j+2)*
					sum(i)(j+1)*sum(i)(j)
				if (tempProd > adjProd)
					adjProd = tempProd
				// Down Right Diagonal
				tempProd = sum(i+3)(j+3)*sum(i+2)(j+2)*
					sum(i+1)(j+1)*sum(i)(j)				
				if (tempProd > adjProd)
					adjProd = tempProd
				// Down Vertical
				tempProd = sum(i+3)(j)*sum(i+2)(j)*
					sum(i+1)(j)*sum(i)(j)
				if (tempProd > adjProd)
					adjProd = tempProd
				// Down Left Diagonal
				tempProd = sum(i+3)(j-3)*sum(i+2)(j-2)*
					sum(i+1)(j-1)*sum(i)(j)
				if (tempProd > adjProd)
					adjProd = tempProd
				// Left Vertical
				tempProd = sum(i)(j-3)*sum(i)(j-2)*
					sum(i)(j-1)*sum(i)(j)
				if (tempProd > adjProd)
					adjProd = tempProd	
		}
		print(adjProd)
	}
}