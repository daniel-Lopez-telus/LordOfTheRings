package Game.characters;

import Game.Dice;

public abstract class Heroe extends Character {
    
    public Heroe(String name, int shieldResistance) {
        super(name, shieldResistance);
    }

    public boolean isHeroe(){
        return true;  
    }

    @Override
    public int throwDices(){
        int firstDice = Dice.throwDice(100);
        int secondDice = Dice.throwDice(100);
        return Math.max(firstDice, secondDice);
    }

    public abstract boolean fears(Character character);

    public abstract boolean hates();

    public abstract int attackOpponent(Character character);

    public abstract int defend(Character character);

    public abstract int getCharacterType();

}
