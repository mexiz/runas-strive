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

public class RunaThrust extends PhysicalAbility {

    private static final int ABILITY_VALUE = 6;
    private static final int ABILITY_VALUE_DICE = 4;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaThrust(int level) {
        super.setValue(ABILITY_VALUE, ABILITY_VALUE_DICE);
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, false, "Thrust");
    }
} 