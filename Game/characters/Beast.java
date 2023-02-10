package Game.characters;

import Game.Dice;

public abstract class Beast extends Character{

    public Beast(String name, int shieldResistance) {
        super(name, shieldResistance);
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
