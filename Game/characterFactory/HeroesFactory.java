package Game.characterFactory;

import Game.characters.Elf;
import Game.characters.Hobbit;
import Game.characters.Human;

public class HeroesFactory implements AbstractCharacterFactory {

    @Override
    public Character createCharacter(String type) {
        Character myCharacter = switch (type) {
            case "Human" -> new Human();
            case "Elf" -> new Elf();
            case "Hobbit" -> new Hobbit();
            default -> null;
        };
        return myCharacter;
    } 
}
