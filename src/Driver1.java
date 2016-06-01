import java.util.Scanner;
import java.io.*;

public class Driver1 {
   public static void main(String[] args) throws Exception  {
      Board b = new Board();
      java.io.File file = new java.io.File("input.txt");
      if (file.exists())
         b.readInitialBoard();
      Scanner input = new Scanner(System.in);
      String command;
      boolean move, quit = false;
   	 
      System.out.println("Welcome to 24-Puzzle.  Enjoy the game!" + "\nLoading board from input.txt.");
   	 
      		
   	 
      while (!quit) {
         move = false;
         while (!move) {
            System.out.println("\nCurrent board.");
            b.showBoard();
            System.out.println("Next command.");
            command = input.next();
            switch (command) {
            	
               case "help":System.out.println("Legal commands are:  " 
                     + "\n help - prints out helpful information." 
                     + "\n quit - ends the game." 
                     + "\n move # - attempts to move the tile with that number into the empty position.");
                  break;
            	
               case "quit":System.out.print("Writing to file.  Goodbye."); 
                  b.displayOutput();
                  System.exit(0);
                  break;
            	
               case "move":b.makeMove(input.nextInt());
                  if (b.isCorrect() == true) {
                     System.out.println("Congratualations!\nPuzzle completed.");
                     System.exit(0);
                  }
               			  
                  break;
            			
            }
         			
         }
      	
      }
   
   }
}
