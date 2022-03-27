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

public class RunaLightning extends MagicAbility {

    private static final int ABILITY_VALUE = 5;
    private static final int ADDITION = 2;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaLightning(int level) {
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Lightning");
        super.setValue(MonsterType.FIRE, 5, 2);
    }
}
