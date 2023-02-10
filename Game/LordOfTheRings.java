package Game;

import Game.creatureFactory.AbstractCreaturerFactory;
import Game.creatureFactory.BeastsFactory;
import Game.creatureFactory.HeroesFactory;

public class LordOfTheRings {
    
    private Army heroeArmy;
    private Army beastArmy;
    private Turn turn;
    private CombatHistory combatHistory;
    private int size = 0;

    public void execute(){
       turn.combat();
    }

    public void setup (){
       do{
        System.out.print("Enter army size: ");
        size = Console.getInt();
        System.out.println("SIZE " + size);
       }while(size >= 10);
        heroeArmy = new Army(size);
        beastArmy = new Army(size);
        //createBeastsArmy();
        createHeroesArmy();
        turn = new Turn(heroeArmy, beastArmy);
    }

    private void createBeastsArmy(){
        AbstractCreaturerFactory myFactory = new BeastsFactory();
        //beastArmy.insertIntoArmy(myFactory.createCreature("", null, 0));
        //quizas aca se tire un mensaje en consola
        //pidiendo cual personaje seleccionar
        
    }

    private void createHeroesArmy(){
        AbstractCreaturerFactory myFactory = new HeroesFactory();
        //heroeArmy.insertIntoArmy(myFactory.createCreature("", null, 0));
        int i = 1, shieldResistance = 0, type = 0;
        String name = null;
        boolean error = false;
        do{
            System.out.println("=====ADD HEROE=====");
            System.out.println("Select a heroe type");
            System.out.println("1) Human");
            System.out.println("2) Elf");
            System.out.println("3) Hobbit");
            System.out.print("\tYour option: ");
            type = Console.getInt();
            System.out.print("Heroe name: ");
            name = Console.getString();            
            if(name == ""){
                System.out.println("Please enter a valid name");
                name = Console.getString();
                error = true;
            }
            error = false;
            System.out.print("Heroe shield resistance: ");
            shieldResistance = Console.getInt();
            if(shieldResistance < 50){
                System.out.println("The minimum is 50");
                shieldResistance = Console.getInt();
                error = true;
            }
            error = false;
            heroeArmy.insertIntoArmy(myFactory.createCreature(type, name, shieldResistance));
            i++;
        }while(i <= size || error)
        ;
    }
}
