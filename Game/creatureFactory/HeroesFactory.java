package Game.creatureFactory;

import Game.creatures.Creature;
import Game.creatures.Elf;
import Game.creatures.Hobbit;
import Game.creatures.Human;

public class HeroesFactory implements AbstractCreaturerFactory {

    @Override
    public Creature createCreature(int type,String name,int shieldResistance) {
        Creature myCharacter = switch (type) {
            case 1 -> new Human(name,shieldResistance);
            case 2 -> new Elf(name,shieldResistance);
            case 3 -> new Hobbit(name,shieldResistance);
            default -> null;
        };
        return myCharacter;
    } 
}