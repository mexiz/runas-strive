package edu.kit.informatik.abilities.monster.phys;

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

public class MonsterSmash extends Ability {

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterSmash(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, false, "Smash");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return 8 * super.getLevel();
    }

}
