package Game.characterFactory;

public interface AbstractCharacterFactory {
    
    public Character createCharacter(String type,String name,int shieldResistance);
}
