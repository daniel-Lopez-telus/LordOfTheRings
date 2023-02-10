package Game;

public class CombatHistory {
    
    private int turnNumber;
    private int damage;
    private Character winner;
    private Character loser;

    public CombatHistory(int turnNumber, Character winner, Character loser, int damage){
        this.turnNumber = turnNumber;
        this.damage = damage;
        this.winner = winner;
        this.loser = loser;
    }
}
