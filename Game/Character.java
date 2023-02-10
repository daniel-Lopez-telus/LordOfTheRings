package Game;

public abstract class Character {
    
    enum Character;
    private String name;
    private int lifePoints;
    private int shieldResistance;

    public Character(String name, int lifePoints, int shieldResistance){
        this.name = name;
        this.lifePoints = lifePoints;
        this.shieldResistance = shieldResistance;
    }

    abstract boolean isHeroe();

    abstract int attackOpponent(Character Character);

    abstract int defend(Character Character);

    abstract int throwDices();

    abstract int getCharacterType();

}
