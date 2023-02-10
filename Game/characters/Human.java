package Game.characters;

public class Human extends Heroe {

    public Human(String name, int lifePoints, int shieldResistance) {
        super(name, lifePoints, shieldResistance);
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
        return Characters.HUMAN.ordinal();
    }
    
}
