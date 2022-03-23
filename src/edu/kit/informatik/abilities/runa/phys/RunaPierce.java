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

public class RunaPierce extends Ability {

    public RunaPierce(int level) {
        super.setLevel(level);
        super.setAttackType(AttackType.PHYS);
        super.setCardType(CardType.OFFENSIVE);
        super.setBreakFocus(false);
        super.setName("Pierce");
    }

    @Override
    public int execute(int dice, Runa runa, Monster monster) {
        int damage = (7 * super.getLevel()) + dice;
        if (dice > 5) {
            damage += (5 * super.getLevel());
        }
        return damage;
    }
}
