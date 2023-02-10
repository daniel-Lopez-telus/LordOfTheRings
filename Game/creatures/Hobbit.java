package Game.creatures;

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

    // quizas pasar por parametro el danio calculado previamente por los dados para devolver el ataque final
    // y que este metodo le reste -5 al dano que se le pasa por parametro y retornar el int de ataque final
    @Override
    public int attackOpponent(Creature creature) {
        // estos personajes tienen un miedo especial a los goblins (trasgos) por lo que siempre que se enfrenten
        // perderan 5 unidades en su potencia ofensiva
        if(this.fears() && creature.getCharacterType() == 5) {
            return 5;
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
        return Creatures.HOBBIT.ordinal();
    }
    
}
