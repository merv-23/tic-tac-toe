import java.util.Scanner;

public class Board {
    public static int grid_size;
    public static String[][] game_board = new String[grid_size][grid_size];
    public static Scanner read = new Scanner(System.in);  
    public static String player_state = "X";
    public Board(int grid_size) {
        this.grid_size = grid_size;
    }
    
    public void make_move() {
        String coords = Board.read.nextLine();
        String[] moves = coords.split(" "); // Split by a spaces but any parameter can be specified

        int row = Integer.parseInt(moves[0]); int col = Integer.parseInt(moves[1]);

        if (Board.game_board[row][col] == null) {
            
        }




            
    }

    public void print_board() 
    {
       int k = this.grid_size+1;
       int max_loop = ((this.grid_size*2)+2);
       // Outer loop
       for (int i = 0; i <= max_loop+1; i++) {
          if (i == 0) {System.out.print("    ");}
          if (i % 2 != 0) {System.out.print("   ");}
          // Inner loop
          for (int j = 0; j <= this.grid_size; j++) {
             // Print column numbers
             if (i == 0) {System.out.print(" " + j + "  ");}
             // Print grid section
             if (i > 0 && i % 2 != 0) {
                System.out.print("+---");
                if (j == (this.grid_size)) {System.out.print("+");} 
             }
             // Print grid section with objects
             if (i > 0 && i % 2 == 0) {
                if (j == 0) {System.out.print(k + "  ");} 
                System.out.print("|   ");
                if (j == (this.grid_size)) { System.out.print("|");}
             }   
          }
          // got to next line
          System.out.println();
          if (i % 2 != 0) {k -= 1;}
       }
    }  
}
