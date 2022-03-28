package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;

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
