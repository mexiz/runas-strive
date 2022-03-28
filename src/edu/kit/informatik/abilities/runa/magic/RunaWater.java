package edu.kit.informatik.abilities.runa.magic;

import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;
import edu.kit.informatik.model.ability.runa.MagicAbility;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaWater extends MagicAbility {

    private static final int VALUE_ONE = 4;
    private static final int VALUE_TWO = 0;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaWater(int level) {
        super.setValue(MonsterType.LIGHTNING, VALUE_ONE, VALUE_TWO);
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Water");
    }
}
