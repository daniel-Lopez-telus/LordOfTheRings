package Game;

import java.util.Random;

public abstract class Beast extends Character{

    boolean isHeroe(){
        return false;
    }

    int throwDices(){
        Random myRandom = new Random();
        //desarrollar implementacion del dado
        return 0;
    }
    
    abstract boolean extraPower();

    abstract int attackOpponent(Character character);

    abstract int defend(Character character);

    abstract int getCharacterType();
    
}
