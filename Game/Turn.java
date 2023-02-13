package Game;

import java.util.ArrayList;
import Game.creatures.Creature;
import Game.utils.Creatures;

public class Turn {

    private Army heroeArmy;
    private Army beastArmy;
    private CombatHistory combatHistory;

    public Turn(Army heroeArmy, Army beastArmy) {
        this.heroeArmy = heroeArmy;
        this.beastArmy = beastArmy;
        this.combatHistory = new CombatHistory();
    } 

    public void combat() {
        Creature heroeToBattle;
        Creature beastToBattle;
        ArrayList<Creature> myheroeArmy = heroeArmy.getArmy();
        ArrayList<Creature> mybeastArmy = beastArmy.getArmy();
        boolean isAnyArmyAlive = true;
        int turnNumber = 0;

        while (isAnyArmyAlive && turnNumber <= heroeArmy.getArmySize()) {

            heroeToBattle = null;
            beastToBattle = null;
            int i = 0;
            int j = 0;
            while( (i<heroeArmy.getArmySize()) && (j<beastArmy.getArmySize()) ) {

                boolean myFlag = true;
                while (i<heroeArmy.getArmySize() && myFlag) {
                    if (!(myheroeArmy.get(i).getLifePoints() <= 0)) {
                        heroeToBattle = myheroeArmy.get(i);
                        myFlag = false;
                    }
                    i++;
                }

                boolean beastFlag = true;
                while (j<beastArmy.getArmySize() && beastFlag) {
                    if(!(mybeastArmy.get(j).getLifePoints() <= 0)) {
                        beastToBattle = mybeastArmy.get(j);
                        beastFlag = false;
                    }
                    j++; 
                }

                if((heroeToBattle != null) && (beastToBattle != null)){
                    turnNumber++;
                    hightLightBeforeCombat(heroeToBattle, beastToBattle, turnNumber);
                    heroeVsBeast(heroeToBattle, beastToBattle);
                    highlightAfterCombat(heroeToBattle, beastToBattle);
                    heroeToBattle = null;
                    beastToBattle = null;
                }
            }
            isAnyArmyAlive = (verifyArmyExistance(heroeArmy) == true && verifyArmyExistance(beastArmy) == true);
        }      
    }     

    private void heroeVsBeast(Creature heroe, Creature beast) {
        int heroeNumberAttack = 0;
        int beastNumberAttack = 0;
        int damage = 0;

        heroeNumberAttack = heroe.throwDices();
        beastNumberAttack = beast.throwDices();

        heroeNumberAttack += heroe.attackOpponent(beast);
        if (heroeNumberAttack > beast.getShieldResistance()) {
            damage = heroeNumberAttack - beast.getShieldResistance();
            beast.setNewLifePoints(damage);
        }

        if (!(beast.getLifePoints() <= 0)) {
            if (beast.getCharacterType() == Creatures.Types.ORC) {
                int weakerShieldResistance = beast.attackOpponent(heroe);
                if (beastNumberAttack > weakerShieldResistance) {
                    damage = beastNumberAttack - weakerShieldResistance;
                    heroe.setNewLifePoints(damage);
                }
            } else {
                beastNumberAttack += beast.attackOpponent(heroe);
                if (beastNumberAttack > heroe.getShieldResistance()) {
                    damage = beastNumberAttack - heroe.getShieldResistance();
                    heroe.setNewLifePoints(damage);
                }
            }
        }
    }

    private boolean verifyArmyExistance(Army army){
        long counter = army.getArmy().stream()
            .filter(creature -> creature.getLifePoints() > 0)
            .count();

            if(counter > 0){
                return true;
            }else{
                showTurnResults(army);
                return false;
            }
    }

    private void hightLightBeforeCombat(Creature heroe, Creature beast, int turnNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append("Turn " + turnNumber + ":\n")
        .append(heroe.getName() + "(life=" + heroe.getLifePoints() + ") VS " + beast.getName() + "(life=" + beast.getLifePoints() + ")");
        combatHistory.addToHistory(sb.toString());
    }

    private void highlightAfterCombat(Creature heroe, Creature beast) {
        StringBuilder sb = new StringBuilder();
        sb.append("End of the Fight: " + heroe.getName() + "(life= " + heroe.getLifePoints() + ") and " + beast.getName() + "(life=" + beast.getLifePoints() + ")\n")
        .append("------------------------------------------------------");
        combatHistory.addToHistory(sb.toString());
    }

    public void showTurnResults(Army army){
        combatHistory.showCombatHistory(army);
    }
}