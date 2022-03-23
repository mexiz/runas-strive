package edu.kit.informatik.abilities.runa.defence;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

/**
 * 
 * Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaFocus extends Ability {

    public RunaFocus(int level) {
        super.setLevel(level);
        super.setAttackType(AttackType.NONE);
        super.setCardType(CardType.FOCUS);
        super.setBreakFocus(false);
        super.setName("Focus");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return super.getLevel();
    }
}
