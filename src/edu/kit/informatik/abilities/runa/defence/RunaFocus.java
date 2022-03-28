package edu.kit.informatik.abilities.runa.defence;

import edu.kit.informatik.character.Runa;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.ability.Ability;
import edu.kit.informatik.model.ability.AttackType;
import edu.kit.informatik.model.ability.CardType;

/**
 * 
 * Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaFocus extends Ability {
    
    /**
     * Konstruktor
     * 
     * @param level das Level
     */
    public RunaFocus(int level) {
        super.init(level, AttackType.NONE, CardType.FOCUS, false, "Focus");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return super.getLevel();
    }
}
