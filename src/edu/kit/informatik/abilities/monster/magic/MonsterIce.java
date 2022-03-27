package edu.kit.informatik.abilities.monster.magic;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * 
 * Offensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterIce extends Ability {

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterIce(int level) {
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Ice");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (10 * super.getLevel()) + 2;
    }
}