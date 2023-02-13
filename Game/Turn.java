package Game;

import java.util.ArrayList;
import Game.creatures.Creature;
import Game.utils.Creatures;

public class Turn {

    /**
     * NOTAS:
     * PROCESO DE BATALLA:
     * se enfrentaran siempre los personajes situados en la misma posicion de cada ejercito. Si alguno de los ejercitos
     * dispone de mas efectivos que el contrario los personajes sobrantes no participaran en ese turno de batalla. 
     * 
     * CUANDO UN PERSONAJE MUERA SE ELIMINARA DE SU POSICION Y SE DESPLAZARAN ToDOS SUS COMPANEROS EN POSICIONES POSTERIORES PARA 
     * CUBRIR LA BAJA. DE ESA FORMA ALGUNO DE LOS PERSONAJES INACTIVOS PODRA PARTICIPAR EN LA BATALLA EN LOS SIGUIENTES TURNOS.
     * 
     */

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
        // heroeArmy.getArmy().get(0);
        ArrayList<Creature> myheroeArmy = heroeArmy.getArmy();
        ArrayList<Creature> mybeastArmy = beastArmy.getArmy();
        boolean isAnyArmyAlive = true;
        int turnNumber = 0;

        while (isAnyArmyAlive) {
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
                    i++; //para tomar el siguiente heroe
                }

                boolean beastFlag = true;
                while (j<beastArmy.getArmySize() && beastFlag) {
                    if(!(mybeastArmy.get(j).getLifePoints() <= 0)) {
                        beastToBattle = mybeastArmy.get(j);
                        beastFlag = false;
                    }
                    j++; //para tomar la siguiente bestia
                }

                //si no retorno ningun beast de vuelta tengo un null y no se ejecuta la batalla es como si tuviera un sobrante que no pelea
                if((heroeToBattle != null) && (beastToBattle != null)){
                    turnNumber++;
                    heroeVsBeast(heroeToBattle, beastToBattle);
                    heroeToBattle = null;
                    beastToBattle = null;
                }
                //cuando i y j se salen del rango, ha terminado la ronda del turno, se sale del while y comienza otro turno 
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

        //heroe ataca primero a bestia
        heroeNumberAttack += heroe.attackOpponent(beast);
        if (heroeNumberAttack > beast.getShieldResistance()) {
            damage = heroeNumberAttack - beast.getShieldResistance();
            beast.setNewLifePoints(damage);
        }

        //si la bestia que ha sido atacada ya se queda sin puntos no tiene sentido que esta ataque porque ya esta muerta
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
        // guardar turnNumber, y los datos de los personajes
        combatHistory.addToHistory(null);
    }

    private boolean verifyArmyExistance(Army army){
        long counter = army.getArmy().stream()
            .filter(creature -> creature.getLifePoints() > 0)
            .count();

            if(counter > 0){
                return true;
            }else{
                return false;
            }
    }

    // a definir
    private void showTurnResults(int currenTurn, Creature heroe, Creature beast){
        //TODO
    }
}