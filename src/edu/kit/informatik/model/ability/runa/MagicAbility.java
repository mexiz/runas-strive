package edu.kit.informatik.model.ability.runa;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.ability.Ability;

/**
 * Klasse für die magischen Fähigkeiten
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class MagicAbility extends Ability {

    private static final int MULTIPLIER = 2;
    private int valueOne;
    private int valueTwo;
    private MonsterType preferredMonster;

    /**
     * Setzt die Werte für die Berechnung des Schadens
     * 
     * @param preferredMonster das bevorzugte Monster
     * @param valueOne         der erste Wert
     * @param valueTwo         der zweite Wert
     */
    public void setValue(MonsterType preferredMonster, int valueOne, int valueTwo) {
        this.preferredMonster = preferredMonster;
        this.valueOne = valueOne;
        this.valueTwo = valueTwo;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (MULTIPLIER * super.getLevel() + valueOne) * runa.getFocus();
        if (monster.getMonsterType().equals(preferredMonster)) {
            damage += MULTIPLIER * super.getLevel();
        }
        return damage + valueTwo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((preferredMonster == null) ? 0 : preferredMonster.hashCode());
        result = prime * result + valueOne;
        result = prime * result + valueTwo;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        MagicAbility other = (MagicAbility) obj;
        if (preferredMonster != other.preferredMonster)
            return false;
        if (valueOne != other.valueOne)
            return false;
        if (valueTwo != other.valueTwo)
            return false;
        return true;
    }

}
