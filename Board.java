public class Board {
    public int grid_size;;    
    
    public Board(int grid_size) {
        this.grid_size = grid_size;
    }
    
    public void make_move() {
        
            
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
