package Game;

import Game.characterFactory.AbstractCharacterFactory;
import Game.characterFactory.BeastsFactory;
import Game.characterFactory.HeroesFactory;

public class LordOfTheRings {
    
    private Army heroeArmy;
    private Army beastArmy;
    private Turn turn;
    private CombatHistory CombatHistory;

    public void execute(){
       turn.combat();
    }

    public void setup (){
        heroeArmy = new Army();
        beastArmy = new Army();
        createBeastsArmy();
        createHeroesArmy();
        turn = new Turn(heroeArmy, beastArmy);
    }

    private void createBeastsArmy(){
        AbstractCharacterFactory myFactory = new BeastsFactory();
        beastArmy.insertIntoArmy(myFactory.createCharacter(""));
        //quizas aca se tire un mensaje en consola
        //pidiendo cual personaje seleccionar
        
    }

    private void createHeroesArmy(){
        AbstractCharacterFactory myFactory = new HeroesFactory();
        //quizas aca se tire un mensaje en consola
        //pidiendo cual personaje seleccionar
        heroeArmy.insertIntoArmy(myFactory.createCharacter(""));
    }
}
