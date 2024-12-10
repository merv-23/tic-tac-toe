public class Main 
{
    
   public static void main(String[] args) {
      //int grid_size = Integer.parseInt(args[0]);
      int grid_size = 5;
    
      Player player1 = new Player("X");
      Player player2 = new Player("O");

      game_loop();
   }

   public static void game_loop(Player player1, Player player2) {
      boolean end_game = false;
      boolean player_state_1 = true;

      while (end_game == false) {
         if (player_state_1 = true) {
            player1;
         }
      }
   }

   public static void print_board(int grid_size) 
   {
      int k = grid_size+1;
      int max_loop = ((grid_size*2)+2);
      // Outer loop
      for (int i = 0; i <= max_loop+1; i++) {
         if (i == 0) {System.out.print("    ");}
         if (i % 2 != 0) {System.out.print("   ");}
         // Inner loop
         for (int j = 0; j <= grid_size; j++) {
            // Print column numbers
            if (i == 0) {System.out.print(" " + j + "  ");}
            // Print grid section
            if (i > 0 && i % 2 != 0) {
               System.out.print("+---");
               if (j == (grid_size)) {System.out.print("+");} 
            }
            // Print grid section with objects
            if (i > 0 && i % 2 == 0) {
               if (j == 0) {System.out.print(k + "  ");} 
               System.out.print("|   ");
               if (j == (grid_size)) { System.out.print("|");}
            }   
         }
         // got to next line
         System.out.println();
         if (i % 2 != 0) {k -= 1;}
      }
   }
}
