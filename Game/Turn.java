package Game;

import java.util.ArrayList;

import Game.creatures.Creature;

public class Turn {
    
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
    
        // aqui determinar cuantos turnos seran ejecutados, sugerencia se ejecutaran los turnos hasta que todos los lifePoints
        // de las criaturas esten a cero en cualquier arreglo, esa seria la condicion entonces mejor usar un while 
        for(int i = 0; i < heroeArmy.getArmySize(); i++) {

            for(Creature heroe: heroeArmy.getArmy()) {
                if(heroe.getLifePoints() <= 0){
                    continue;
            }
            heroeNumberAttack = heroe.throwDices();

            for(Creature beast: beastArmy.getArmy()) {
                if(beast.getLifePoints() <= 0){
                    continue;
            }
            beastNumberAttack = beast.throwDices();

            //me devuelve una potenciaReal de ataque o numero total de ataque en funcion de la bestia que se ataque
            heroeNumberAttack += heroe.attackOpponent(beast);
            //calcular danio infligido en funcion del nivel de armadura del defensor
            //solo habra danio si la potencia ofensiva o heroeNumberAttack es superior al nivel de
            // armadura del defensor. Si es asi el danio producido sera la diferencia entre la potencia
            // de ataque y el nivel de armadur adel opononete.
            // if(heroeNumberAttack > shieldResistance)
            // dano = heroeNumberAttack - shieldResistance
            // entonces este danio es lo que le resto a lifePoints del determinado creature
            if(heroeNumberAttack > beast.getShieldResistance()) {
                  damage = heroeNumberAttack - beast.getShieldResistance();
                  beast.setNewLifePoints(damage);
            }
            
            //ahora la bestia ataca, pero si es orco, el nivel de armadura de su oponente se reduce en un 10% (se reduce solo para este turno de ataque)
            if(beast.getCharacterType() == Creatures.ORC.ordinal() { //el enum esta protected)
                //mejor extraigo en currentSHieldresisteance si es un orco el que va atacar, entonces lo guardo, y luego seteo uno temporal para evaluar condicion y luego le vuelvo 
                // a poner de nuevo el currentSHieldresisteance al heroe de turno
                int currentHeroeShieldResistance = heroe.getShieldResistance();
                int weakerShieldResistance = beast.attackOpponent(heroe);
                // hacer un heroe.setTemporaryShieldResistance(weakerShieldResistance);
                // hay que crear el meotdoSHieldResistance en clase abstracta heroe unicamente
                if(beastNumberAttack > heroe.getShieldResistance()) {
                    damage = beastNumberAttack - heroe.getShieldResistance();
                    heroe.setNewLifePoints(damage);
              }
            } 
            beastNumberAttack += beast.attackOpponent(heroe);
            if(beastNumberAttack > heroe.getShieldResistance()) {
                damage = heroeNumberAttack - beast.getShieldResistance();
                beast.setNewLifePoints(damage);
            }
            }
            }
        }
    }

    private int calculateDamageDealt(){
        //TODO
        return 0;
    }

    private void showTurnResults(int currenTurn, Creature heroe, Creature beast){
        //TODO
    }
    
}
