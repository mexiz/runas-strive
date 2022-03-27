package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * 
 * Defensive Monster Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class MonsterDeflect extends Ability {

    private static final int NEGATE = -1;
    private static final int ABILITY_VALUE = 11;
    private static final int ADDITION_VALUE = 2;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterDeflect(int level) {
        super.init(level, AttackType.MAGIC, CardType.DEFENSIV, false, "Deflect");

    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return NEGATE * ((ABILITY_VALUE * super.getLevel()) + ADDITION_VALUE);
    }

}
