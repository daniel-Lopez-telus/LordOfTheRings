package Game.creatureFactory;

import Game.creatures.Creature;

public interface AbstractCreaturerFactory {
    
    public Creature createCreature(String type,String name,int shieldResistance);
}
