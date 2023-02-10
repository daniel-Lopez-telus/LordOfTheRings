package Game.creatureFactory;

import Game.creatures.Creature;
import Game.creatures.Elf;
import Game.creatures.Hobbit;
import Game.creatures.Human;

public class HeroesFactory implements AbstractCreaturerFactory {

    @Override
    public Creature createCreature(String type,String name,int shieldResistance) {
        Creature myCharacter = switch (type) {
            case "Human" -> new Human(name,shieldResistance);
            case "Elf" -> new Elf(name,shieldResistance);
            case "Hobbit" -> new Hobbit(name.shieldResistance);
            default -> null;
        };
        return myCharacter;
    } 
}