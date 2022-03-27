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

public class MonsterScratch extends Ability {

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterScratch(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, true, "Scratch");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return 5 * super.getLevel();
    }
}
