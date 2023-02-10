package Game.characterFactory;

public interface AbstractCharacterFactory {
    
    public Game.characters.Character createCharacter(String type);
}
