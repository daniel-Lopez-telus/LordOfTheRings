package Game.characters;

import java.util.Random;

import Game.Dice;

public abstract class Beast extends Character{

    public Beast(String name, int lifePoints, int shieldResistance) {
        super(name, lifePoints, shieldResistance);
        //TODO Auto-generated constructor stub
    }

    public boolean isHeroe(){
        return false;
    }

    public int throwDices(){
        return Dice.throwDice(90);
    }
    
    public abstract boolean extraPower();

    public abstract int attackOpponent(Character character);

    public abstract int defend(Character character);

    public abstract int getCharacterType();
    
}
