import java.util.ArrayList;
import java.util.Scanner;

public class Board {
   private final int grid_size;
   private static String[][] game_board;
   private ArrayList<Integer> crossed = new ArrayList<>();
   private static final Scanner read = new Scanner(System.in);
   private static String player_state = " ";
   private static Boolean first_move = true;
   private static String winner;
   private static Boolean some_body_won = false;
   private static int player_x_score;
   private static int player_o_score;

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

   private String check_up(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i + 1][j])) {
            crossed.add(i);
            return check_up(i + 1, j, depth + 1);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_diagonal_down_right(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i - 1][j + 1])) {
            return check_diagonal_down_right(i - 1, j + 1, depth + 1);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_diagonal_up_left(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i + 1][j - 1])) {
            return check_diagonal_up_left(i + 1, j - 1, depth + 1);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_right(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i][j + 1])) {
            return check_right(i, j + 1, depth + 1);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_diagonal_up_right(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i + 1][j + 1])) {
            return check_diagonal_up_right(i + 1, j + 1, depth + 1);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_diagonal_down_left(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i - 1][j - 1])) {
            return check_diagonal_down_left(i - 1, j - 1, depth + 1);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_left(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i][j - 1])) {
            return check_left(i, j - 1, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_down(int i, int j, int depth) {
      if (depth == 2) {
         return "It's done";
      }
      try {
         if (Board.game_board[i][j].equals(Board.game_board[i - 1][j])) {
            return check_down(i - 1, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "Nope";
   }

   private String check_the_thing(int i, int j, int depth) {
      try {
         if (game_board[i][j].equals(game_board[i + 1][j])) {
            return check_up(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      try {

         if (Board.game_board[i][j].equals(Board.game_board[i - 1][j + 1])) {
            return check_diagonal_down_right(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      try {

         if (Board.game_board[i][j].equals(Board.game_board[i + 1][j - 1])) {
            return check_diagonal_up_left(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      try {
         if (game_board[i][j].equals(game_board[i][j + 1])) {
            return check_right(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      try {
         if (game_board[i][j].equals(game_board[i + 1][j + 1])) {
            return check_diagonal_up_right(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      try {
         if (game_board[i][j].equals(game_board[i - 1][j - 1])) {
            return check_diagonal_down_left(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      try {
         if (game_board[i][j].equals(game_board[i][j - 1])) {
            return check_left(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      try {
         if (game_board[i][j].equals(game_board[i - 1][j])) {
            return check_down(i, j, depth);
         }
      } catch (ArrayIndexOutOfBoundsException e) {
      }
      return "not today brody";
   }

   @SuppressWarnings("StringEquality")
   private void win_lose(String s) {
      String target = s;
      int depth = 0;

      for (int i = 0; i <= this.grid_size; i++) {
         for (int j = 0; j <= this.grid_size; j++) {
            if (game_board[i][j] == target) {
               if (check_the_thing(i, j, depth) == "It's done") {
                  if (target == "X") {
                     player_x_score += 1;
                     break;
                  } else {
                     player_o_score += 1;
                     break;
                  }
               }
            }
         }
      }
   }

   public Boolean got_a_winner() {
      if ((player_x_score > player_o_score) && got_space() == false) {
         some_body_won = true;
         winner = "X wins";
      } else if ((player_o_score > player_x_score) && got_space() == false) {
         some_body_won = true;
         winner = "O wins";
      } else if ((player_x_score == player_o_score) && got_space() == false) {
         some_body_won = true;
         winner = "Well... it's a draw.";
      }
      return some_body_won;
   }

   public String get_winner() {
      return winner;
   }

   public Boolean got_space() {
      for (int i = 0; i <= this.grid_size; i++) {
         for (int j = 0; j <= this.grid_size; j++) {
            if (game_board[i][j] != null) {
               return true;
            }
         }
      }
      return false;
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