package Game.creatures;

import Game.utils.Creatures.Types;

public class Elf extends Heroe{

    public Elf(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 250;
        this.shieldResistance = shieldResistance;
    }

    @Override
    public boolean fears() {
        return false;
    }

    @Override
    public boolean hates() {
        return true;
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
        // si el oponente es un orco incrementa su potencia ofensiva en 10 unidades. 
        if(this.hates() && creature.getCharacterType() == Types.ORC) {
            return 10;
        }
        return 0;
    }

    @Override
    public Types getCharacterType() {
        return Types.ELF;
    }
}