package Game;

import java.util.ArrayList;

import Game.creatures.Creature;



public class Army {
    
    ArrayList<Creature> army;

    public Army(int size){
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
}
