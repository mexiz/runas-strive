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

public class RunaWater extends MagicAbility {

    private static final int ABILITY_VALUE = 2;
    private static final int ADDITION = 4;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaWater(int level) {
        super.setValue(MonsterType.LIGHTNING, 4, 0);
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Water");
    }
}
