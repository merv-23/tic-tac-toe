public class Main 
{
   public static void main(String[] args) {
      //int grid_size = Integer.parseInt(args[0]);
      int grid_size = 5;
    
      game_loop(grid_size);
   }

   public static void game_loop(int grid_size) {
      Board gameBoard = new Board(grid_size);
      gameBoard.print_board();

      for (int i = 0; i < 10; i++) {
         gameBoard.make_move();
         gameBoard.print_board();
      }
   }


}
