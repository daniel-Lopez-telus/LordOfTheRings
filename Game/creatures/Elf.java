package Game.creatures;

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

    // quizas pasar por parametro el danio calculado previamente por los dados para devolver el ataque final
    // y que este metodo le sume +10 al dano que se le pasa por parametro y retornar el int de ataque final
    @Override
    public int attackOpponent(Creature creature) {
        // si el oponente es un orco incrementa su potencia ofensiva, que es la calculada con los dados mas
        // 10 unidades. 
        if(this.hates() && creature.getCharacterType() == 4) {
            return 10;
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
        return Creatures.ELF.ordinal();
    }
    
}
