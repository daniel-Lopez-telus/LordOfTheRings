package Game.characterFactory;

import Game.characters.Goblin;
import Game.characters.Orc;

public class BeastsFactory implements AbstractChgiaracterFactory{

    @Override
    public Character createCharacter(String type) {
        Character myCharacter = switch (type) {
            case "Orc" -> new Orc();
            case "Goblin" -> new Goblin();
            default -> null;
        };
        return myCharacter;
    }
}
