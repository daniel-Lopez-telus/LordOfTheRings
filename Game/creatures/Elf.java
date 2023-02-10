package Game.creatures;

public class Elf extends Heroe{

    public Elf(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 250;
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
        return Creatures.ELF.ordinal();
    }
    
}
