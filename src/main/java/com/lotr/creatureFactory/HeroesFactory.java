package com.lotr.creatureFactory;

import com.lotr.creatures.Creature;
import com.lotr.creatures.Elf;
import com.lotr.creatures.Hobbit;
import com.lotr.creatures.Human;

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