package Game.characterFactory;

import Game.characters.Elf;
import Game.characters.Hobbit;
import Game.characters.Human;

public class HeroesFactory implements AbstractCharacterFactory {

    @Override
    public Character createCharacter(String type,String name,int shieldResistance) {
        Character myCharacter = switch (type) {
            case "Human" -> new Human(name,shieldResistance);
            case "Elf" -> new Elf(name,shieldResistance);
            case "Hobbit" -> new Hobbit(name.shieldResistance);
            default -> null;
        };
        return myCharacter;
    } 
}
