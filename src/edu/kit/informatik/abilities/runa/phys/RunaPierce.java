package edu.kit.informatik.abilities.runa.phys;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaPierce extends Ability {

    private static final int ABILITY_VALUE = 7;
    private static final int DICE_LIMIT = 5;
    private static final int ABILITY_VALUE_DICE = 5;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaPierce(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, false, "Pierce");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (ABILITY_VALUE * super.getLevel()) + dice;
        if (dice > DICE_LIMIT) {
            damage += (ABILITY_VALUE_DICE * super.getLevel());
        }
        return damage;
    }
}
