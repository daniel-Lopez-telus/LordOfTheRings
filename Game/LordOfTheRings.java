package Game;

import Game.creatureFactory.AbstractCreaturerFactory;
import Game.creatureFactory.BeastsFactory;
import Game.creatureFactory.HeroesFactory;
import Game.utils.Console;

public class LordOfTheRings {

    private Army heroeArmy;
    private Army beastArmy;
    private Turn turn;
    private CombatHistory combatHistory;
    private int size = 0;

    public void execute() {
        turn.combat();
    }

    public void setup() {
        do {
            System.out.print("Enter army size: ");
            size = Console.getInt();
        } while (size >= 10);
        heroeArmy = new Army(size);
        beastArmy = new Army(size);
        createHeroesArmy();
        createBeastsArmy();
        turn = new Turn(heroeArmy, beastArmy);
    }

    private void createBeastsArmy() {
        AbstractCreaturerFactory myFactory = new BeastsFactory();
        int i = 1;
        do {
            int  shieldResistance = 0, type = 0;
            String name = "";
            System.out.println("=====ADD BEAST #" + i + "=====");
            System.out.println("Select a beast type");
            System.out.println("4) Orc");
            System.out.println("5) Goblin");
            while (type < 4 || type > 5) {
                System.out.print("\tYour option: ");
                type = Console.getInt();
            }
            fillCreatureInfo(name,shieldResistance);       
            beastArmy.insertIntoArmy(myFactory.createCreature(type, name, shieldResistance));
            i++;
        } while (i <= size);
    }

    private void createHeroesArmy() {
        AbstractCreaturerFactory myFactory = new HeroesFactory();
        int i = 1;
        do {
            int  shieldResistance = 0, type = 0;
            String name = "";
            System.out.println("=====ADD HEROE #" + i + "=====");
            System.out.println("Select a heroe type");
            System.out.println("1) Human");
            System.out.println("2) Elf");
            System.out.println("3) Hobbit");
            while (type <= 0 || type > 3) {
                System.out.print("\tYour option: ");
                type = Console.getInt();
            }
            fillCreatureInfo(name,shieldResistance);       
            heroeArmy.insertIntoArmy(myFactory.createCreature(type, name, shieldResistance));
            type = 0;
            name = "";
            shieldResistance = 0;
            i++;
        } while (i <= size);
    }

    private void fillCreatureInfo(String name, int shieldResistance) {
        System.out.print("Heroe name: ");
        name = Console.getString();
        while (shieldResistance < 50) {
            System.out.print("Heroe shield resistance (Min = 50): ");
            shieldResistance = Console.getInt();
        }
    }
}
