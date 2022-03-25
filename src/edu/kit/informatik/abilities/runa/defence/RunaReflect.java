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

    public RunaReflect(int level) {
        super.init(level, AttackType.MAGIC, CardType.DEFENSIV, false, "Reflect");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (-10) * super.getLevel();
    }

}
