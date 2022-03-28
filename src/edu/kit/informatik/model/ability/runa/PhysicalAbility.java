package edu.kit.informatik.model.ability.runa;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;

/**
 * Klasse für die magischen Fähigkeiten
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class PhysicalAbility extends Ability {

    private static final int DICE_LIMIT = 6;

    private int valueOne;
    private int valueTWO;

    /**
     * Setzt die Werte für die Berechnung des Schadens
     * 
     * @param valueOne der erste Wert
     * @param valueTWO der zweite Wert
     */
    public void setValue(int valueOne, int valueTWO) {
        this.valueOne = valueOne;
        this.valueTWO = valueTWO;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (valueOne * super.getLevel()) + dice;
        return dice < DICE_LIMIT ? damage : (damage + (valueTWO * super.getLevel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + valueOne;
        result = prime * result + valueTWO;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PhysicalAbility other = (PhysicalAbility) obj;
        if (valueOne != other.valueOne || valueTWO != other.valueTWO) {
            return false;
        }
        return true;
    }

}
