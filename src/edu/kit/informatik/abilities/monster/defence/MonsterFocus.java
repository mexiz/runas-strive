
package edu.kit.informatik.abilities.monster.defence;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;

/**
 * Fokus Fähigkeitskarte
 * 
 * @author uwlhp
 * @version 1.0.0
 */
public class MonsterFocus extends Ability {

    private static final int ABILITY_VALUE = 1;

    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public MonsterFocus(int level) {
        super.init(level, AttackType.NONE, CardType.FOCUS, false, "Focus");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return ABILITY_VALUE * super.getLevel();
    }
}
