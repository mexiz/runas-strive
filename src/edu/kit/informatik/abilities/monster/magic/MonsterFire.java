package edu.kit.informatik.abilities.monster.magic;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;

/**
 * 
 * Offensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterFire extends Ability {

    private static final int ABILITY_VALUE = 12;
    private static final int ADDITION_VALUE = 2;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterFire(int level) {
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Fire");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (ABILITY_VALUE * super.getLevel()) + ADDITION_VALUE;
    }
}
