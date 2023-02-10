package Game.creatures;

public class Goblin extends Beast{

    public Goblin(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 200;
        this.shieldResistance = shieldResistance;
    }

    @Override
    public boolean extraPower() {
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
        return Creatures.GOBLIN.ordinal();
    }
    
}