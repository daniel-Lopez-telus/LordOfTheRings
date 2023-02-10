package Game;

import java.util.ArrayList;

import Game.characters.Character;

public class Army {
    
    ArrayList<Character> army;

    public Army(){
        this.army = new ArrayList<>();
    }

    public void insertIntoArmy(Character character){
        army.add(character);
    }

    public ArrayList<Character> getArmy() {
        return army;
    }
}
