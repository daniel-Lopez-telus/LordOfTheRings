package Game;

import java.util.Random;

public abstract class Heroe {
    
    boolean isHeroe(){
        return true;  
    }

    int throwDices(){
        Random myRandom = new Random();
        //implementacion del metodo 
        //if()
        return 0;
    }

    abstract boolean fears(Character character);

    abstract boolean hates();

    abstract int attackOpponent(Character character);

    abstract int defend(Character character);

    abstract int getCharacterType();

}
