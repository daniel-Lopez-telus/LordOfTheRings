package Game;

import Game.creatures.Creature;

public class CombatHistoryItem {

    private int turnNumber;
    private Creature heroe;
    private Creature beast;

    
    
    public CombatHistoryItem(int turnNumber, Creature heroe, Creature beast) {
        this.turnNumber = turnNumber;
        this.heroe = heroe;
        this.beast = beast;
    }


    @Override
    public String toString() {
        return "turnNumber=" + turnNumber + heroe.getName() + " (lifePoints=" + heroe.getLifePoints() + ") " + 
        "VS. " + beast.getName() + " (lifePoints=" + beast.getLifePoints() + ")";
    }

}
