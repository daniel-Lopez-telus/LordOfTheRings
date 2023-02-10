package Game.creatureFactory;

import Game.creatures.Creature;
import Game.creatures.Goblin;
import Game.creatures.Orc;

public class BeastsFactory implements AbstractCreaturerFactory{

    @Override
    public Creature createCreature(int type,String name,int shieldResistance) {
        Creature myCharacter = switch (type) {
            case 4 -> new Orc(name,shieldResistance);
            case 5 -> new Goblin(name,shieldResistance);
            default -> null;
        };
        return myCharacter;
    }
}
