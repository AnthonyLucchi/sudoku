import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class main {

	/**
	 * @param args
	 */
	static Integer[][] sudoku;


	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub



		sudoku = new Integer[9][9];

		//Scans from the system.in
		File fin = new File("skyline.txt");
		
		Scanner scanIn = new Scanner(fin);
		//declare a scanner to read from system.in

		int numCases = 0;
		
		numCases = scanIn.nextInt();

		//Declares a instance of puzzle
		sudoku = new Integer[9][9];

		//Scanning in the inital eight puzzle
		for ( int i = 0; i < 9; i++ ){
			for ( int j = 0; j<9; j++){
				sudoku[i][j] = scanIn.nextInt();
			}
		}

		/*
		Integer[][] sudoku = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		 */

		Solver s = new Solver();

		s.printArray(sudoku);
		s.solve(sudoku,0,0);

	}
	
}


