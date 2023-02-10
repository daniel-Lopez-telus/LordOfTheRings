package Game.characters;

public class Orc extends Beast{

    public Orc(String name, int lifePoints, int shieldResistance) {
        super(name, lifePoints, shieldResistance);
    }

    @Override
    public boolean extraPower() {
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
        return Characters.ORC.ordinal();
    }
    
}
