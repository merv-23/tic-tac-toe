public class Player {
    public final String symbol;
 

    
    // Constructor
    public Player(String s) {
        symbol = s;
    }


    public static void change_state() {
        
    }

    @Override
    public String toString() {
        return symbol;
    }
}
