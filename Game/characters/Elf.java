package Game.characters;

public class Elf extends Heroe{

    public Elf(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 250;
        this.shieldResistance = shieldResistance;
    }

    @Override
    public boolean fears(Character character) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hates() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int attackOpponent(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int defend(Character character) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getCharacterType() {
        return Characters.ELF.ordinal();
    }
    
}
