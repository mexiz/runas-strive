package edu.kit.informatik.abilities.monster.phys;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * 
 * offensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterBite extends Ability {

    private static final int ABILITY_VALUE = 10;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterBite(int level) {
        super.init(level, AttackType.PHYS, CardType.OFFENSIVE, false, "Bite");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return ABILITY_VALUE * super.getLevel();
    }
}
