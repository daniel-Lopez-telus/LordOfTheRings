package Game;

public class Main {
    
    public static void main(String[] args) {
        
        LordOfTheRings myGame = new LordOfTheRings();
        myGame.setup();
        myGame.execute();
        myGame.statistics();
    }
}