package Game;

import java.util.ArrayList;

public class CombatHistory {

    private ArrayList<String> combatHistory = new ArrayList<>();

    public void addToHistory(String item){
        combatHistory.add(item);
    }

    public void showCombatHistory(Army army){
        combatHistory.forEach(System.out::println);
        System.out.println("\n========END OF THE BATTLE========");
        System.out.println(army.getArmyName() + " HAVE BEEN DEFEATED");
    }
}