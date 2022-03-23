package edu.kit.informatik.abilities.runa.phys;

import edu.kit.informatik.Runa;
import edu.kit.informatik.model.AttackType;
import edu.kit.informatik.model.CardType;
import edu.kit.informatik.model.Monster;
import edu.kit.informatik.model.Ability;

/**
 * 
 * Offensive Runa Fähigkeitskarte
 * 
 * @author uwhlp
 * @version 1.0.0
 * 
 */

public class RunaSwing extends Ability {

    public RunaSwing(int level) {
        super.setLevel(level);
        super.setAttackType(AttackType.PHYS);
        super.setCardType(CardType.OFFENSIVE);
        super.setBreakFocus(true);
        super.setName("Swing");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        return (5 * super.getLevel()) + dice;
    }
}
