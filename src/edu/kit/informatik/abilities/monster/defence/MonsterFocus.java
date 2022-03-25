
package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.Runa;

import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Ability;
import edu.kit.informatik.model.Monster;

/**
 * Fokus Fähigkeitskarte
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class MonsterFocus extends Ability {

    public MonsterFocus(int level) {
        super.init(level, AttackType.NONE, CardType.FOCUS, false, "Focus");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return super.getLevel();
    }
}
