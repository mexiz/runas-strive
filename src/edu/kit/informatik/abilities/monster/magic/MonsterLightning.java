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

public class MonsterLightning extends Ability {

    public MonsterLightning(int level) {
        super.init(level, AttackType.MAGIC, CardType.OFFENSIVE, false, "Lightning");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (14 * super.getLevel()) + 2;
    }
}