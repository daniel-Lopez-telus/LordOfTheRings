package Game.characters;

public abstract class Character {
    
    protected enum Characters{
        HUMAN,
        ELF,
        HOBBIT,
        ORC,
        GOBLIN
    };
    
    protected String name;
    protected int lifePoints;
    protected int shieldResistance;

    public Character(String name, int shieldResistance){
        this.name = name;
        this.shieldResistance = shieldResistance;
    }

    public abstract boolean isHeroe();

    public abstract int attackOpponent(Character Character);

    public abstract int defend(Character Character);

    public abstract int throwDices();

    public abstract int getCharacterType();

}
