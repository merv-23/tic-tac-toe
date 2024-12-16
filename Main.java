public class Main {
   public static void main(String[] args) {
      // int grid_size = Integer.parseInt(args[0]);
      int grid_size = 3;

      game_loop(grid_size);
   }

   public static void game_loop(int grid_size) {
      Board gameBoard = new Board(grid_size);
      gameBoard.print_board();
      Boolean end = false;

      while (end == false) {
         gameBoard.make_move();
         if (gameBoard.got_a_winner() == true) {
            end = true;
            System.out.println(gameBoard.get_winner() + " won");
         }
      }
   }
}
