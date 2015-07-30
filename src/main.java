import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import android.os.Handler

import dev.groupx.minigames.alphabet.Alphabet.updateTimerReference;
public class main {

	/**
	 * @param args
	 */
	static Integer[][] sudoku;
	
	// Declaring a new handler to update the timer
	public Handler mHandler = new Handler();
	//Refresh every second
		private final int REFRESH_RATE = 10;
		//Declare string for the timer
		doWork workThread = new doWork();
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		sudoku = new Integer[9][9];
		
		for ( int i = 0; i < 9; i ++ ){
			for ( int j = 0; j < 9; j ++ ){
				sudoku[i][j] = 0; 
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
		
		// We start the clock
		mHandler.postDelayed(clockTimer, REFRESH_RATE);
		
	}
	
	class doWork implements Runnable {

		
		
		public void run(){

			Solver s = new Solver();
			
			s.printArray(sudoku);
			s.solve(sudoku,0,0);
			
		}

	}


}


