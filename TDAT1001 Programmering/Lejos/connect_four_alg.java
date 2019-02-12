import java.util.Random;

public class connect_four_alg {
	// Size of grid
	int height;
	int width;

	// Color-values in array
	int red = 1;
	int green = 2;

	// Position array, default value of int = 0 (empty)
	int position[][];


	connect_four(int position[][]) {
		this.position = position;
		this.width = position.length; // Items in array
		this.height = position[0].length; // Items in sub-array
	}

	int winner() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int colorValue = position[x][y];

				// If colorValue is zero, jump to next itteration
				if (colorValue == 0) {continue;}

				// Check right values
				if ((x+3) < width) {
					if ((position[x][y] == colorValue) &&
						(position[x+1][y] == colorValue) &&
						(position[x+2][y] == colorValue) &&
						(position[x+3][y] == colorValue)) {
						return colorValue;
					}	
				}

				// Check left values
				if ((x-3) > 0) {
					if ((position[x][y] == colorValue) &&
						(position[x-1][y] == colorValue) &&
						(position[x-2][y] == colorValue) &&
						(position[x-3][y] == colorValue)) {
						return colorValue;
					}	
				}

				// Check up
				if ((y+3) < height) {
					if((position[x][y] == colorValue) &&
						(position[x][y+1] == colorValue) &&
						(position[x][y+2] == colorValue) &&
						(position[x][y+3] == colorValue)) {
						return colorValue;
					}
				} 
					

				// Check right diagonal
				if (((x+3) < width) && ((y+3) < height)) {
					if ((position[x][y] == colorValue) &&
						(position[x+1][y+1] == colorValue) &&
						(position[x+2][y+2] == colorValue) &&
						(position[x+3][y+3] == colorValue)) {
						return colorValue;
					}
				}
					

				// Check left diagonal
				if (((x-3) > 0) && ((y+3) < height)) {
					if ((position[x][y] == colorValue) &&
						(position[x-1][y+1] == colorValue) &&
						(position[x-2][y+2] == colorValue) &&
						(position[x-3][y+3] == colorValue)) {
						return colorValue;
					}
				}
			}
		}

		return 0; // No one won
	}

	int possible_yValue(int xValue) {
		// Check for possible y-value
		for (int y = 0; y < height; y++) {
			if (position[xValue][y] == 0) {
				return y;
			}
		}
		// Return -1 if there is no possible y-value
		// The row is full
		return -1;
	}

	boolean fullBoard() {
		int counter = 0;
		// Check if board is not full
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if (position[x][y] != 0) {
					counter++;
				}
			}
		} 

		// Total amount in the grid
		if (counter == 42) {
			return true;
		}
		return false;
	}


	int bestMove() {
		/* 
		- Method to check which row has the highest probability of winning
		- Checks the outcome of random placements on row 1-7 (0-6 in array) n amounts of times
		- The row with the highest probability will be returned 
		*/

		double p = 0; // The best probability 
		int winnerRow = 0; // The row that gives us the highest probability to win
		Random randomGenerator = new Random(); //Random generator

		// Saving the last state of array to
		int position_last[][] = new int[this.width][this.height];

		// Depp copy of array to avoid mutations
		for (int x = 0; x < this.position.length; x++) {
			for (int y = 0; y < this.position[0].length; y++) {
					position_last[x][y] = this.position[x][y];
			}
		}
		
		for (int row = 0; row < width; row++) {
			int redWon = 0;
			int greenWon = 0;
			int iterations = 10000; // Change for more accuracy
			int yValue = 0; // Will be used for possible y-values 

			// Update array where we are in row itteration
			if (possible_yValue(row) == -1) {
				continue; // Jump to next row
			} else {
				yValue = possible_yValue(row);
				this.position[row][yValue] = red;
			}

			// More iterations for more accuracy probability
			for (int i = 0; i < iterations; i++) {
				// While no one has yet won and board is not full
				int counter = 1; // Opponent starts
				while(winner() == 0 && !fullBoard()) {
					// Find a random row that is not full
					int randomNum = randomGenerator.nextInt(width);
					while ((yValue = possible_yValue(randomNum)) == -1) {
						randomNum = randomGenerator.nextInt(width);
					}
					yValue = possible_yValue(randomNum);

					// Robots turn is always even
					if (counter % 2 == 0) {
						this.position[randomNum][yValue] = red;
					// Opponents turn 
					} else if (counter % 2 != 0) {
						this.position[randomNum][yValue] = green;
					}
					counter++;
				}

				// Register who won this round
				if (winner() == 1) {redWon++;}
				else if (winner() == 2) {greenWon++;}

				// Reseting the position array for next round
				for (int x = 0; x < this.position.length; x++) {
					for (int y = 0; y < this.position[0].length; y++) {
						this.position[x][y] = position_last[x][y];
					}
				}
				// Adding the current row to the array
				yValue = possible_yValue(row);
				this.position[row][yValue] = red;
			}
			// Printing the probability of each row, and the amount of wins
			System.out.println("Row: " + row + " red: " + redWon);
			System.out.println("Row: " + row + " green: " + greenWon);

			// After n amount of rounds, check who won the most, and calculate probability
			double current_p =  (double) redWon / (double) iterations;
			System.out.println("current: " + current_p);
	
			if (current_p > p) {
				p = current_p;
				winnerRow = row;
			}
		}

		return winnerRow;
	}	

	public static void main(String[] args) {
		int position[][] = {
			{0,0,0,0,0,0}, 
			{0,0,0,0,0,0},
			{1,2,2,1,0,0},
			{2,2,1,1,1,2},
			{2,1,2,1,0,0},
			{2,2,1,2,0,0},
			{1,1,0,0,0,0}
		};
		connect_four testObj = new connect_four(position);
		System.out.println(testObj.bestMove());

	}
} 