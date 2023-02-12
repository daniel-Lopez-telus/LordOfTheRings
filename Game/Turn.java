package Game;

import java.util.ArrayList;
import Game.creatures.Creature;

public class Turn {

    /**
     * NOTAS:
     * 1. QUE VA A SUCEDER SI TENEMOS UN CREATURE MUERTO EN CUALQUIER ARMY? ENTONCES EL CREATURE DEL OTRO LADO YA NO PELEA?
     * 2. DEFINIR LA CLASE COMBATHISTORY... PUEDE SER LA QUE VAYA IMPRIMIENDO LOS MENSAJES EN CONSOLA EN CADA TURNO PERO ES 
     * SOLAMENTE UNA IDEA!!
     * 3. EL METODO DEFEND DE LA CLASE CREATURE ES PROBABLE QUE YA NO SEA MAS UTIL, NUNCA LA USE. ESTUDIAR METODO COMBAT :)
     * 4. ECHAR OJO A LA CONDICION beast.getCharacterType() == Creatures.ORC.ordinal() DE LA LINEA 61.
     */
    
    //los ejercitos son clases que contienen arreglos de heroes y bestias
    private Army heroeArmy;
    private Army beastArmy;
    private int heroeAttack;
    private int beastAttack;
    private int damageDealt;
    private CombatHistory combatHistory;

    public Turn(Army heroeArmy, Army beastArmy) {
        this.heroeArmy = heroeArmy;
        this.beastArmy = beastArmy;
        this.combatHistory = new CombatHistory();
        combatHistory = new CombatHistory();
    } 

    public void combat() {
        int heroeNumberAttack = 0;
        int beastNumberAttack = 0; 
        int damage = 0;
    
        // Determinar cuantos turnos seran ejecutados:
        // cuando y hasta que los lifePoints de todo un army esten a cero entonces la condicion del while sera falsa
        // la condicion del while seria una condicion compuesta de dos subcondiciones de heroeArmy y beastArmy
        while (verifyArmyExistance(heroeArmy) == true && verifyArmyExistance(beastArmy) == true) {
            for (Creature heroe : heroeArmy.getArmy()) {
                if (heroe.getLifePoints() <= 0) {
                    continue;
                }
                heroeNumberAttack = heroe.throwDices();

                for (Creature beast : beastArmy.getArmy()) {
                    if (beast.getLifePoints() <= 0) {
                        continue;
                    }
                    beastNumberAttack = beast.throwDices();

                    heroeNumberAttack += heroe.attackOpponent(beast);
                    if (heroeNumberAttack > beast.getShieldResistance()) {
                        damage = heroeNumberAttack - beast.getShieldResistance();
                        beast.setNewLifePoints(damage);
                    }

                    // bestia ataca pero, si es orco, el nivel de armadura de su oponente se reduce en un 10% (se reduce solo para este turno de ataque)
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
        }
    }

    private boolean verifyArmyExistance(Army army){
        int counter = army.getArmy().stream()
            .filter(creature -> creature.getLifePoints() > 0)
            .count();

            if(counter > 0){
                return true;
            }else{
                return false;
            }
    }

    // este metodo me quedo sin usar
    private int calculateDamageDealt(){
        //TODO
        return 0;
    }

    //definir que va hacer nuestro combatHistory y hacer un display por cada turno como en el ejemplo... solo son ideas de mi cabeza. metodo por definir
    private void showTurnResults(int currenTurn, Creature heroe, Creature beast){
        //TODO
    }
    
}
