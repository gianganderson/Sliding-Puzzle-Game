import java.util.*;
import java.io.*;
import java.io.PrintWriter;
public class Board {
	private int[][] the_frame;
	private int emptyUnit;
	private Scanner input;
	
	
	
	public Board() {
		the_frame = new int[5][5];
		emptyUnit = 0;
	}
	
	public void readInitialBoard() {
		try {
			input = new Scanner(new File("input.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Input.txt was not found!");
			return;
		}
		for (int row = 0; row < the_frame.length; row++) {
			for (int column = 0; column < the_frame.length; column++) {
				the_frame[row][column] = input.nextInt();
			}
		}
	}
   
    public void displayOutput()throws Exception {
      java.io.File file1 = new java.io.File("output.txt");
      PrintWriter output = new PrintWriter(file1);
      for (int row = 0; row < the_frame.length; row++) {
         for (int column = 0; column < the_frame[row].length; column++) {
            output.printf(the_frame[row][column] + " ");
          }
            output.println();
     }
            output.close();
}            

	
	public void makeMove(int number) {
      // Declare x and y as 0, which will be the array that the user wants to move.
      // Declare x2 and y2 as 0,which will be the coordinates for the empty unit.
      int x = 0; int y = 0; int x2 = 0; int y2 = 0; int temp;
         for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
               if (the_frame[row][column] == emptyUnit) {
                  x2 = row;
                  y2 = column;
               }
            }
        }
         for (int row = 0; row < 5; row++) {
        	 for (int column = 0; column < 5; column ++) {
        		 if (the_frame[row][column] == number) {
        			 x = row;
        			 y = column;
        		 }
        	 }
         }
         if (((x == (x2 + 1)) && (y == y2)) || ((x == x2) && (y == (y2 - 1)))|| ((x == x2) && (y == (y2 + 1))) || ((x == (x2 - 1)) && (y == y2))) {                 
        	 temp = the_frame[x2][y2];
  		     the_frame[x2][y2] = the_frame[x][y];
  		     the_frame[x][y] = temp;
	   }
	   else {
		   System.out.println("Invalid move. Try again.");
	   }
  }
	
	public void showBoard() {

		for (int row = 0; row < the_frame.length; row++) {
			System.out.print("");
			System.out.println("-----------------------------------------");
			for (int column = 0; column < the_frame[row].length; column++) {
				System.out.print("|   ");
				/*if(the_frame[row][column] > 0)
					System.out.print("" + the_frame[row][column] + "\t");
				else */
					System.out.print("" + "" + "\t");	
			}
		System.out.println("|");
		}	
			System.out.print("");
			System.out.println("-----------------------------------------");
	}
	
	public boolean isCorrect() {
		if ((the_frame[0][0] == 1) && (the_frame[0][1] == 2) && (the_frame[0][2] == 3) 
				&& (the_frame[0][3] == 4) && (the_frame[0][4] == 5)
			    && (the_frame[1][0] == 6) && (the_frame[1][1] == 7) && (the_frame[1][2] == 8)
			    && (the_frame[1][3] == 9) && (the_frame[1][4] == 10)
			    && (the_frame[2][0] == 11) && (the_frame[2][1] == 12) && (the_frame[2][2] == 13) 
			    && (the_frame[2][3] == 14) && (the_frame[2][4] == 15)
			    && (the_frame[3][0] == 16) && (the_frame[3][1] == 17) && (the_frame[3][2] == 18) 
			    && (the_frame[3][3] == 19) && (the_frame[3][4] == 20)
			    && (the_frame[4][0] == 21) && (the_frame[4][1] == 22) && (the_frame[4][2] == 23)
			    && (the_frame[4][3] == 24) && (the_frame[4][4] == 0)) 
			return true;
            else {
        	      return false;
         }
		
	}
}