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

    public Creature getCreature(int position) {
        return army.get(position);
    }

    public int getArmySize() {
        return this.army.size();
    }
}
