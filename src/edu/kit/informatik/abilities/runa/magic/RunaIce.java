package edu.kit.informatik.abilities.runa.magic;

import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.MagicAbility;
import edu.kit.informatik.model.MonsterType;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaIce extends MagicAbility {

    private static final int VALUE_ONE = 4;
    private static final int VALUE_TWO = 2;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaIce(int level) {
        super.setValue(MonsterType.WATER, VALUE_ONE, VALUE_TWO);
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Ice");
    }
}
