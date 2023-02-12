package Game.creatures;

import Game.utils.Creatures;

public class Hobbit extends Heroe{

    public Hobbit(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 200;
        this.shieldResistance = shieldResistance;
    }

    @Override
    public boolean fears() {
        return true;
    }

    @Override
    public boolean hates() {
        return false;
    }

    @Override
    public int getLifePoints(){
        return this.lifePoints;
    }

    @Override
    public int getShieldResistance() {
        return this.shieldResistance;
    }

    @Override
    public void setNewLifePoints(int damage) {
        this.lifePoints -= damage;
    }

    @Override
    public int attackOpponent(Creature creature) {
        // estos personajes tienen un miedo especial a los goblins (trasgos) por lo que siempre que se enfrenten
        // perderan 5 unidades en su potencia ofensiva
        if(this.fears() && creature.getCharacterType() == 5) {
            return -5;
        }
        return 0;
    }

    @Override
    public int defend(Creature creature) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getCharacterType() {
        return Creatures.Types.HOBBIT.ordinal();
    }

}
