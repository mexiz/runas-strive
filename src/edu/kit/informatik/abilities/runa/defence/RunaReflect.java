package edu.kit.informatik.abilities.runa.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

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
