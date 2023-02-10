package Game;

import java.util.ArrayList;

import Game.creatures.Creature;



public class Army {
    
    ArrayList<Creature> army;

    public Army(){
        this.army = new ArrayList<>();
    }

    public void insertIntoArmy(Creature creature){
        army.add(creature);
    }

    public ArrayList<Creature> getArmy() {
        return army;
    }
}
