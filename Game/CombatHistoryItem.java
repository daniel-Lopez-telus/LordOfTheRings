package Game;

import Game.creatures.Creature;

public class CombatHistoryItem {

    private int turnNumber;
    private Creature heroe;
    private Creature beast;
    
    @Override
    public String toString() {
        return "[turnNumber=" + turnNumber + 
        heroe.getName() + "(lifePoints=" + heroe.getLifePoints() + ") " + 
        "VS. " + beast.getName() + "(lifePoints=" + beast.getLifePoints() + ")";
    }

}
