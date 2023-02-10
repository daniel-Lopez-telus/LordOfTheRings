package Game.creatures;

public class Human extends Heroe {


    public Human(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 180;
        this.shieldResistance = shieldResistance;

    }

    @Override
    public boolean fears(Creature character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hates() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int attackOpponent(Creature character) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int defend(Creature character) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getCharacterType() {
        return Creatures.HUMAN.ordinal();
    }
    
}
