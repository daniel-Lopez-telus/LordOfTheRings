package Game;

import Game.creatureFactory.AbstractCreaturerFactory;
import Game.creatureFactory.BeastsFactory;
import Game.creatureFactory.HeroesFactory;

public class LordOfTheRings {
    
    private Army heroeArmy;
    private Army beastArmy;
    private Turn turn;
    private CombatHistory combatHistory;

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
        AbstractCreaturerFactory myFactory = new BeastsFactory();
        beastArmy.insertIntoArmy(myFactory.createCreature("", null, 0));
        //quizas aca se tire un mensaje en consola
        //pidiendo cual personaje seleccionar
        
    }

    private void createHeroesArmy(){
        AbstractCreaturerFactory myFactory = new HeroesFactory();
        //quizas aca se tire un mensaje en consola
        //pidiendo cual personaje seleccionar
        heroeArmy.insertIntoArmy(myFactory.createCreature("", null, 0));
    }
}
