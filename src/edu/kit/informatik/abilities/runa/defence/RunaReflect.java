package edu.kit.informatik.abilities.runa.defence;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;

/**
 * 
 * Defensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaReflect extends Ability {

    private static final int ABILITY_VALUE = -10;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaReflect(int level) {
        super.init(level, AttackType.MAGIC, CardType.DEFENSIV_REFLECT, false, "Reflect");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return ABILITY_VALUE * super.getLevel();
    }

}
