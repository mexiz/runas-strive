package edu.kit.informatik.abilities.runa.magic;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.MonsterType;
import edu.kit.informatik.model.Ability;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaIce extends Ability {

    private static final int ABILITY_VALUE = 2;
    private static final int ADDITION = 4;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaIce(int level) {
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Ice");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (ABILITY_VALUE * super.getLevel()) + ADDITION;
        damage *= runa.getFocus();
        damage += ABILITY_VALUE;
        if (monster.getMonsterType().equals(MonsterType.WATER)) {
            damage += ABILITY_VALUE * super.getLevel();
        }
        return damage;
    }

}
