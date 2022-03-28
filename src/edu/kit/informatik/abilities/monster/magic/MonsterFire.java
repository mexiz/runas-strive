package edu.kit.informatik.abilities.monster.magic;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;

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
