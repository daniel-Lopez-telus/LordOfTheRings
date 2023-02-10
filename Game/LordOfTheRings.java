package Game;

public class LordOfTheRings {
    
    private Army heroeArmy;
    private Army beastArmy;
    private Turn turn;
    private CombatHistory CombatHistory;

    public void execute(){
        //TODO
    }

    public void setup (){
        createBeastsArmy();
        createHeroesArmy();
        turn = new Turn(heroeArmy, beastArmy);
    }

    private void createBeastsArmy(){
        //TODO
    }

    private void createHeroesArmy(){
        //TODO
    }


}
