package Game.creatures;

import Game.utils.Creatures;

public class Orc extends Beast{

    public Orc(String name, int shieldResistance) {
        super(name, shieldResistance);
        this.name = name;
        lifePoints = 200;
        this.shieldResistance = shieldResistance;
    }

    //El extraPower creo que ya no sera utilizado 
    @Override
    public boolean extraPower() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int getLifePoints() {
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
    public int attackOpponent(Creature heroe) {
        // si el orco ataca, el nivel de armadura de su oponente se reduce en un 10% (se reduce solo para este turno de ataque)
        int temporaryShieldResistance = heroe.getShieldResistance() - (int)(heroe.getShieldResistance()*0.10);
        return temporaryShieldResistance;
    }

    @Override
    public int defend(Creature character) {
        return 0;
    }

    @Override
    public int getCharacterType() {
        return Creatures.Types.ORC.ordinal();
    }
    
}
