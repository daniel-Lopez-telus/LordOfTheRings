package com.lotr.creatures;

import com.lotr.utils.Dice;

public abstract class Beast extends Creature{

    public Beast(String name, int shieldResistance) {
        super(name, shieldResistance);
    }

    @Override
    public boolean isHeroe(){
        return false;
    }

    @Override
    public int throwDices(){
        return Dice.throwDice(90);
    }
}