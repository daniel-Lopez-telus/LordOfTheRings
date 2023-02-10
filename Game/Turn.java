package Game;

public class Turn {
    
    //los ejercitos son arreglos
    private Army heroeArmy;
    private Army beastArmy;
    private int heroeAttack;
    private int beastAttack;
    private int damageDealt;
    private CombatHistory CombatHistory;

    public Turn(Army heroeArmy, Army beastArmy, CombatHistory combatHistory) {
        this.heroeArmy = heroeArmy;
        this.beastArmy = beastArmy;
        this.CombatHistory = combatHistory;
        combat();
    } 

    private void combat(Army heroeArmy, Army beastArmy) {
     
        
    }

    private int calculateDamageDealt(){}

    private void showTurnResults(int currenTurn, Character heroe, Character beast){
        
    }
    
}
