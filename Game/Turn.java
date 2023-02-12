package Game;

import java.util.ArrayList;
import Game.creatures.Creature;
import Game.utils.Creatures;

public class Turn {

    /**
     * NOTAS:
     * 1. QUE VA A SUCEDER SI TENEMOS UN CREATURE MUERTO EN CUALQUIER ARMY? ENTONCES EL CREATURE DEL OTRO LADO YA NO PELEA?
     * R/ en cada turno un personaje de un ejercito atacara a un unico adversario del ejercito oponente. 
     * se enfrentaran siempre los personajes situados en la misma posicion de cada ejercito. Si alguno de los ejercitois
     * dispone de mas efectivos que el contrario los personajes sobrantes no participaran en ese turno de batalla. 
     * 
     * 
     * 2. DEFINIR LA CLASE COMBATHISTORY... PUEDE SER LA QUE VAYA IMPRIMIENDO LOS MENSAJES EN CONSOLA EN CADA TURNO PERO ES 
     * SOLAMENTE UNA IDEA!!
     */
    
    //los ejercitos son clases que contienen arreglos de heroes y bestias
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

            heroeVsBeast(heroeToBattle, beastToBattle);
            //hacer una funcion que verifique los lifePoints de todas las criaturas de cada army 
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
