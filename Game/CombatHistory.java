package Game;

import java.util.ArrayList;

public class CombatHistory {
    
    private ArrayList<CombatHistoryItem> combatHistory = new ArrayList<>();

    public void addToHistory(CombatHistoryItem item){
        combatHistory.add(item);
    }

    public void showHistory(){
        System.out.println("\t========AT THE END OF THE BATTLE========");
        combatHistory.forEach(item -> System.out.println(item.toString()));
    }
    

}
