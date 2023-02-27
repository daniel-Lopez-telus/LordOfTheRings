package com.lotr.creatureFactory;

import com.lotr.creatures.Creature;
import com.lotr.creatures.Goblin;
import com.lotr.creatures.Orc;

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