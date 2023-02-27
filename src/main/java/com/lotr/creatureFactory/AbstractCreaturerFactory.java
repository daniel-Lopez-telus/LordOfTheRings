package com.lotr.creatureFactory;

import com.lotr.creatures.Creature;

public interface AbstractCreaturerFactory {
    
    public Creature createCreature(int type, String name, int shieldResistance);
}