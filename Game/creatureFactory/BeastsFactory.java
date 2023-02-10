package Game.creatureFactory;

import Game.creatures.Creature;
import Game.creatures.Goblin;
import Game.creatures.Orc;

public class BeastsFactory implements AbstractCreaturerFactory{

    @Override
    public Creature createCreature(String type,String name,int shieldResistance) {
        Creature myCharacter = switch (type) {
            case "Orc" -> new Orc(name,shieldResistance);
            case "Goblin" -> new Goblin(name,shieldResistance);
            default -> null;
        };
        return myCharacter;
    }
}
