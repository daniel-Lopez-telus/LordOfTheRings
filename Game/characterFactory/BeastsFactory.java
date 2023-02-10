package Game.characterFactory;

import Game.characters.Goblin;
import Game.characters.Orc;

public class BeastsFactory implements AbstractChgiaracterFactory{

    @Override
    public Character createCharacter(String type,String name,int shieldResistance) {
        Character myCharacter = switch (type) {
            case "Orc" -> new Orc(name,shieldResistance);
            case "Goblin" -> new Goblin(name,shieldResistance);
            default -> null;
        };
        return myCharacter;
    }
}
