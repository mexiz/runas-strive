package edu.kit.informatik.model.ability.runa;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

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
     * @param preferredMonster das bevorzugte Monster
     * @param valueOne         der erste Wert
     */
    public void setValue(int valueOne, int valueTWO) {
        this.valueOne = valueOne;
        this.valueTWO = valueTWO;
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (valueOne * super.getLevel()) + dice;
        return dice >= DICE_LIMIT ? damage : damage + (valueTWO * super.getLevel());
    }

}
