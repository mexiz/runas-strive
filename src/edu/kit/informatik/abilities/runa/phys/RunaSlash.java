package edu.kit.informatik.abilities.runa.phys;

import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.ability.runa.PhysicalAbility;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaSlash extends PhysicalAbility {

    private static final int ABILITY_VALUE = 4;
    private static final int ABILITY_VALUE_DICE = 0;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaSlash(int level) {
        super.setValue(ABILITY_VALUE, ABILITY_VALUE_DICE);
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, true, "Slash");
    }
}
