package Game;

import Game.creatures.Creature;

public class Turn {
    
    //los ejercitos son arreglos
    private Army heroeArmy;
    private Army beastArmy;
    private int heroeAttack;
    private int beastAttack;
    private int damageDealt;
    private CombatHistory combatHistory;

    public Turn(Army heroeArmy, Army beastArmy) {
        this.heroeArmy = heroeArmy;
        this.beastArmy = beastArmy;
        this.combatHistory = new CombatHistory();
        combatHistory = new CombatHistory();
    } 

    public void combat() {
     //TODO
        
    }

    private int calculateDamageDealt(){
        //TODO
        return 0;
    }

    private void showTurnResults(int currenTurn, Creature heroe, Creature beast){
        //TODO
    }
    
}
