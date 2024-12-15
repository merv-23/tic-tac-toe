import java.util.Scanner;

public class Board {
   private final int grid_size;
   private static String[][] game_board;
   private static final Scanner read = new Scanner(System.in);
   private static String player_state = " ";
   private static Boolean first_move = true;

   // Constructor
   public Board(int grid_size) {
      this.grid_size = grid_size - 1;
      Board.game_board = new String[grid_size][grid_size];
   }

   public void make_move() {
      // Read co-ordinates from standard input
      String coords = Board.read.nextLine();
      String[] moves = coords.split(" "); // Split by a spaces but any parameter can be specified

      int row = Integer.parseInt(moves[0]);
      int col = Integer.parseInt(moves[1]);

      if (row < 0) {
         row = 0;
      }
      if (col < 0) {
         col = 0;
      }

      if (Board.first_move == true) {
         Board.player_state = "X";
         Board.first_move = false;
      }

      // Add X or O to board array
      if (Board.game_board[row][col] == null) {
         Board.game_board[row][col] = Board.player_state;
      } else {
         System.out.println("You made a oopsie");
      }

      // Change to either an X or O depending on who went last
      if ("X".equals(Board.player_state)) {
         Board.player_state = "O";
         win_lose("X");
      } else if ("O".equals(Board.player_state)) {
         Board.player_state = "X";
         win_lose("O");
      }

      print_board();
   }

   private String check_the_thing(int i, int j, int depth) {
      

      if (depth == 3) {
         return "It's done";
      }
      else if (Board.game_board[i][j].equals(Board.game_board[i + 1][j])) {
         return check_the_thing(i+1, j, depth+1);
      } 
      else if (Board.game_board[i][j].equals(Board.game_board[i][j + 1])) {
         return check_the_thing(i, j+1, depth+1);
      } 
      else if (Board.game_board[i][j].equals(Board.game_board[i + 1][j + 1])) {
         return check_the_thing(i+1, j+1, depth+1);
      }
         else if (Board.game_board[i][j].equals(Board.game_board[i - 1][j - 1])) {
         return check_the_thing(i-1, j-1, depth+1);
      } 
      else if (Board.game_board[i][j].equals(Board.game_board[i][j - 1])) {
         return check_the_thing(i, j-1, depth+1);
      }
         else if (Board.game_board[i][j].equals(Board.game_board[i - 1][j])) {
         return check_the_thing(i-1, j, depth);
      } 
      else {
         return "not today brody";
      }
   }

   @SuppressWarnings("StringEquality")
   private void win_lose(String s) {
      String target = s;
      int depth = 0;
      try {
         for (int i = 0; i <= Board.game_board.length; i++) {
            for (int j = 0; j <= Board.game_board.length; j++) {
               if (Board.game_board[i][j] == target) {
                  if (check_the_thing(i, j, depth) == "It's done") {
                     System.err.println("yerr");
                  }
               }
            }
         }
      } catch (IndexOutOfBoundsException e) {
      }

   }

   public Boolean still_playing() {

      return true;
   }

   private String get_state(int k, int j) {
      int row = k;
      int col = j;

      if (Board.game_board[row][col] == null) {
         return " ";
      } else {
         return Board.game_board[row][col];
      }
   }

   public void print_board()
   // Print board to commandline
   {
      int k = this.grid_size + 1;
      int max_loop = ((this.grid_size * 2) + 2);
      // Outer loop
      for (int i = 0; i <= max_loop + 1; i++) {
         if (i == 0) {
            System.out.print("    ");
         }
         if (i % 2 != 0) {
            System.out.print("   ");
         }
         // Inner loop
         for (int j = 0; j <= this.grid_size; j++) {
            // Print column numbers
            if (i == 0) {
               System.out.print(" " + j + "  ");
            }
            // Print grid section
            if (i > 0 && i % 2 != 0) {
               System.out.print("+---");
               if (j == (this.grid_size)) {
                  System.out.print("+");
               }
            }
            // Print grid section with objects
            if (i > 0 && i % 2 == 0) {
               if (j == 0) {
                  System.out.print(k + "  ");
               }
               System.out.printf("| %s ", get_state(k, j));
               if (j == (this.grid_size)) {
                  System.out.print("|");
               }
            }
         }
         // got to next line
         System.out.println();
         if (i % 2 != 0) {
            k -= 1;
         }
      }
   }
}