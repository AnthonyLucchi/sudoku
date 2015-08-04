import java.util.ArrayList;
import java.util.Collections;

public class Solver {



	public boolean solve(Integer[][] currentPosition, int startRow, int startCol){


		if(isSolved(currentPosition)){
			printArray(currentPosition);
			return true;
		}

		int nextRow = 0;
		int nextCol = 0;

		// If this cell is already set(fixed), skip to the next cell
		if (currentPosition[startRow][startCol] != 0) {
			if (solve(currentPosition, startCol == 8? (startRow + 1): startRow, (startCol + 1) % 9))
				return true;
		}
		else{
			//Integer[] rando = randomArray();
			Integer[] rando = {1,2,3,4,5,6,7,8,9};

			//looping through the random array

			for(int k = 0; k < 9; k++ ){

				//System.out.println(startRow +" , "+ startCol + "  " + "Checking " + rando[k]);


				if(!isInGrid(startRow, startCol, rando[k], currentPosition) && !containedInRowCol(startRow,startCol,rando[k],currentPosition) ){
					//System.out.print("Hi");
					currentPosition[startRow][startCol] = rando[k];

					if(startCol + 1 > 8){
						nextRow = startRow + 1;
						nextCol = 0;
					}
					else{
						nextCol = startCol + 1;
					}

					printArray(currentPosition);

					if (solve(currentPosition, nextRow, nextCol))
						return true;

					currentPosition[startRow][startCol] = 0;

				}
			}
		}

		return false;
	}

	/*Return true if target found in 3x3*/
	private boolean isInGrid(int row, int col, int target, Integer[][] currentBoard) {

		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;

		for (int i = startRow; i < startRow + 3; i++)
			for (int j = startCol; j < startCol + 3; j++) {
				if (!(i == row && j == col)) {
					if (currentBoard[i][j] == target) {

						//System.out.println("Found: " + target);
						return true;
					}
				}
			}

		return false;
	}

	/*Returns true if in column or row*/
	private boolean containedInRowCol (int row, int col, int target, Integer[][] currentBoard){

		for (int i = 0; i < 9; i ++){
			if ( i != col )
				if (currentBoard[row][i] == target){
					//System.out.println("Col");
					return true;
				}
			if ( i != row )
				if (currentBoard[i][col] == target){
					//System.out.println("Row");
					return true;
				}
		}


		return false;
	}

	private Integer[] randomArray(){
		ArrayList<Integer> rando = new ArrayList<Integer>();
		for (int i = 0 ; i < 9; i ++) {
			rando.add(i + 1);
		}
		Collections.shuffle(rando);

		return rando.toArray(new Integer[9]);
	}

	public void printArray(Integer[][] curBoard){
		for(int i = 0; i < 9; i ++){
			for ( int j = 0; j < 9; j ++){
				System.out.print(curBoard[i][j] +  " ");
			}

			System.out.println();
		}


		System.out.println("\n");
	}


	/**
	 * Check if all cells are filled up.
	 * @return true if Sudoku is full.
	 */
	private boolean isSolved(Integer[][] currentBoard) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				if (currentBoard[i][j] == 0)
					return false;

		return true;
	}

}
