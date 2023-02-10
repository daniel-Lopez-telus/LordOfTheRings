package Game.creatures;

public abstract class Creature {
    
    protected enum Creatures{
        HUMAN,
        ELF,
        HOBBIT,
        ORC,
        GOBLIN
    };
    
    protected String name;
    protected int lifePoints;
    protected int shieldResistance;

    public Creature(String name, int shieldResistance){
        this.name = name;
        this.shieldResistance = shieldResistance;
    }

    public abstract boolean isHeroe();

    public abstract int attackOpponent(Creature Character);

    public abstract int defend(Creature Character);

    public abstract int throwDices();

    public abstract int getCharacterType();

}
