package com.lotr.creatures;

import com.lotr.utils.Creatures.Types;

public class Human extends Heroe {

    public Human(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 180;
        this.shieldResistance = shieldResistance;

    }

    @Override
    public boolean fears() {
        return false;
    }

    @Override
    public boolean hates() {
        return false;
    }

    @Override
    public int getLifePoints() {
        return this.lifePoints;
    }

    @Override
    public int getShieldResistance() {
        return this.shieldResistance;
    }

    @Override
    public void setNewLifePoints(int damage) {
        this.lifePoints -= damage;
    }

    @Override
    public int attackOpponent(Creature character) {
        return 0;
    }

    @Override
    public Types getCharacterType() {
        return Types.HUMAN;
    }   
}