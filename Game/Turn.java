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
     * CUANDO UN PERSONAJE MUERA SE ELIMINARA DE SU POSICION Y SE DESPLAZARAN TIDOS SUS COMPANEROS EN POSICIONES POSTERIORES PARA 
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
        combatHistory = new CombatHistory();
    } 

    public void combat() {
        Creature heroeToBattle;
        Creature beastToBattle;
        boolean isAnyArmyAlive = true;

        while (isAnyArmyAlive) {
            heroeToBattle = null;
            beastToBattle = null;
            for (Creature heroe : heroeArmy.getArmy()) {
                if (heroe.getLifePoints() <= 0) {
                    continue;
                }
                heroeToBattle = heroe;
                break;
            }

            for (Creature beast : beastArmy.getArmy()) {
                if (beast.getLifePoints() <= 0) {
                    continue;
                }
                beastToBattle = beast;
                break;
            }
            
            // creo que si no retorno ningun beast de vuelta tengo un null y no se ejecuta la batalla es como si tuviera un sobrante que no pelea
            if((heroeToBattle != null) && (beastToBattle != null)){
                heroeVsBeast(heroeToBattle, beastToBattle);
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
            if (beast.getCharacterType() == Creatures.ORC.ordinal()) { //el enum esta protected, mejor igualar a un numero)
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
                return false;
            }
    }

    //definir que va hacer nuestro combatHistory y hacer un display por cada turno como en el ejemplo... solo son ideas de mi cabeza. metodo por definir
    private void showTurnResults(int currenTurn, Creature heroe, Creature beast){
        //TODO
    }
    
}
