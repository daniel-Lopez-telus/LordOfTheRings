package Game.creatureFactory;

import Game.creatures.Creature;

public interface AbstractCreaturerFactory {
    
    public Creature createCreature(int type,String name,int shieldResistance);
}
