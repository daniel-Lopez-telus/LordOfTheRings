package Game;

import Game.characters.Character;

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
        this.CombatHistory = combatHistory;
        combatHistory = new CombatHistory();
    } 

    private void combat(Army heroeArmy, Army beastArmy) {
     //TODO
    }

    private int calculateDamageDealt(){
        //TODO
    }

    private void showTurnResults(int currenTurn, Character heroe, Character beast){
        //TODO
    }
    
}
