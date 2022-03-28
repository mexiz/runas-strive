package edu.kit.informatik.abilities.runa.phys;

import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;
import edu.kit.informatik.model.ability.runa.PhysicalAbility;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaPierce extends PhysicalAbility {

    private static final int ABILITY_VALUE = 7;
    private static final int ABILITY_VALUE_DICE = 5;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaPierce(int level) {
        super.setValue(ABILITY_VALUE, ABILITY_VALUE_DICE);
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, false, "Pierce");
    }
}
