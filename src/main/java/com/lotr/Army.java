package com.lotr;

import java.util.ArrayList;
import com.lotr.creatures.Creature;

public class Army {
    
    private String armyName;
    ArrayList<Creature> army;

    public Army(String name, int size){
        this.armyName = name;
        this.army = new ArrayList<>(size);
    }

    public void insertIntoArmy(Creature creature){
        army.add(creature);
    }

    public ArrayList<Creature> getArmy() {
        return army;
    }

    public int getArmySize() {
        return this.army.size();
    }

    public String getArmyName() {
        return this.armyName;
    }
}