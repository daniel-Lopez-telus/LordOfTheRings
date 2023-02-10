package Game.creatures;

import Game.Dice;

public abstract class Heroe extends Creature {
    
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

    public abstract boolean fears(Creature character);

    public abstract boolean hates();

    public abstract int attackOpponent(Creature character);

    public abstract int defend(Creature character);

    public abstract int getCharacterType();

}
